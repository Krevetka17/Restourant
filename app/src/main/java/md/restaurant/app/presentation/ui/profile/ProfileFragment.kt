package md.restaurant.app.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.data.remote.ApiClient
import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.databinding.FragmentProfileBinding
import md.restaurant.app.utils.AuthManager

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(i, c, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()

        binding.btnLogin.setOnClickListener { showLogin() }
        binding.btnRegister.setOnClickListener { showRegister() }
        binding.btnLogout.setOnClickListener {
            AuthManager.logout(requireContext())
            updateUI()
            Toast.makeText(requireContext(), "Вышли из аккаунта", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val user = AuthManager.getUser(requireContext())
        if (user != null) {
            binding.groupLoggedIn.visibility = View.VISIBLE
            binding.groupLoggedOut.visibility = View.GONE
            binding.tvUserName.text = user.name
            binding.tvUserEmail.text = user.email
        } else {
            binding.groupLoggedIn.visibility = View.GONE
            binding.groupLoggedOut.visibility = View.VISIBLE
        }
    }

    private fun showLogin() {
        // Можно сделать диалог, но пока просто используем поля
        val email = binding.etEmail.text.toString()
        val pass = binding.etPassword.text.toString()
        if (email.isEmpty() || pass.isEmpty()) return

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    ApiClient.api.login(AuthRequest(email, pass))
                }
                AuthManager.saveAuth(requireContext(), response.token, response.user)
                updateUI()
                Toast.makeText(requireContext(), "Вход успешен!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка входа", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showRegister() {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val pass = binding.etPassword.text.toString()
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) return

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    ApiClient.api.register(AuthRequest(email, pass, name))
                }
                AuthManager.saveAuth(requireContext(), response.token, response.user)
                updateUI()
                Toast.makeText(requireContext(), "Регистрация успешна!", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка регистрации", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}