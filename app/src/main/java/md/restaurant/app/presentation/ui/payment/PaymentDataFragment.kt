package md.restaurant.app.presentation.ui.profile.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.R
import md.restaurant.app.data.remote.AuthApiClient
import md.restaurant.app.databinding.FragmentPaymentDataBinding
import md.restaurant.app.utils.AuthManager

class PaymentDataFragment : Fragment() {

    private var _binding: FragmentPaymentDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PaymentMethodsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener { parentFragmentManager.popBackStack() }

        adapter = PaymentMethodsAdapter { cardId -> showDeleteConfirmation(cardId) }
        binding.rvCards.layoutManager = LinearLayoutManager(context)
        binding.rvCards.adapter = adapter

        binding.addCardContainer.setOnClickListener {
            showAddCardDialog()
        }

        loadCards()
    }

    private fun loadCards() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val freshUser = AuthApiClient.api.getCurrentUser()  // ← свежий запрос
                AuthManager.saveAuth(requireContext(), AuthManager.getToken(requireContext())!!, freshUser)
                val cards = freshUser.paymentMethods ?: emptyList()
                adapter.submitList(cards)
            } catch (e: Exception) {
                Toast.makeText(context, "Ошибка загрузки", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showAddCardDialog() {
        parentFragmentManager.commit {
            replace(R.id.profile_container, AddCardFragment())
            addToBackStack("add_card")
        }
    }

    private fun showDeleteConfirmation(cardId: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("Удалить карту")
            .setMessage("Вы уверены? Это действие нельзя отменить.")
            .setPositiveButton("Удалить") { _, _ -> deleteCard(cardId) }
            .setNegativeButton("Отмена", null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .create()
            .show()
    }

    private fun deleteCard(cardId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = AuthApiClient.api.deletePaymentMethod(cardId)
                withContext(Dispatchers.Main) {
                    if (response.success) {
                        val currentUser = AuthManager.getUser(requireContext())!!
                        val updatedUser = currentUser.copy(paymentMethods = response.paymentMethods)
                        AuthManager.saveAuth(requireContext(), AuthManager.getToken(requireContext())!!, updatedUser)
                        loadCards()
                        Toast.makeText(context, "Карта удалена", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Ошибка удаления: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}