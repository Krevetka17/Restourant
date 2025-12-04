package md.restaurant.app.presentation.ui.profile.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.R
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.databinding.FragmentAdminRequestsBinding
import md.restaurant.app.presentation.ui.profile.ProfileFragment
import md.restaurant.app.presentation.ui.profile.main.MainProfileFragment
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AdminRequestsListFragment : Fragment() {

    private var _binding: FragmentAdminRequestsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: AdminRequestsAdapter

    override fun onCreateView(inf: LayoutInflater, cg: ViewGroup?, s: Bundle?): View {
        _binding = FragmentAdminRequestsBinding.inflate(inf, cg, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.recyclerRequests.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdminRequestsAdapter(
            onApprove = { id -> resolveRequest(id, "approve") },
            onReject = { id -> resolveRequest(id, "reject") }
        )
        binding.recyclerRequests.adapter = adapter

        loadRequests()
    }

    private fun loadRequests() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val requests = withContext(Dispatchers.IO) {
                    Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthApiService::class.java)
                        .getAdminRequests()
                }

                if (requests.isEmpty()) {
                    binding.tvEmpty.visibility = VISIBLE
                    binding.recyclerRequests.visibility = GONE
                } else {
                    binding.tvEmpty.visibility = GONE
                    binding.recyclerRequests.visibility = VISIBLE
                    adapter.submitList(requests)
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun resolveRequest(requestId: String, action: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                withContext(Dispatchers.IO) {
                    Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthApiService::class.java)
                        .resolveRequest(requestId, mapOf("action" to action, "adminId" to AuthManager.getUser(requireContext())!!.id))
                }

                Toast.makeText(requireContext(), if (action == "approve") "Принято" else "Отклонено", Toast.LENGTH_SHORT).show()

                // Перезагружаем список
                loadRequests()

                // Если одобрили — обновляем данные пользователя в AuthManager
                if (action == "approve") {
                    // Перезагружаем пользователя с сервера
                    reloadCurrentUser()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun reloadCurrentUser() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val freshUser = withContext(Dispatchers.IO) {
                    Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthApiService::class.java)
                        .getCurrentUser()
                }
                AuthManager.saveAuth(
                    requireContext(),
                    AuthManager.getToken(requireContext())!!,
                    freshUser
                )

                // ← ВАЖНО: обновляем MainProfileFragment
                (parentFragment?.parentFragment as? ProfileFragment)?.let { profileFragment ->
                    (profileFragment.childFragmentManager.findFragmentById(R.id.profile_container) as? MainProfileFragment)
                        ?.updateUserInfo()
                }
            } catch (e: Exception) {
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}