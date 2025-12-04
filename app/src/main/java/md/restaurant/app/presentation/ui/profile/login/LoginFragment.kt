package md.restaurant.app.presentation.ui.profile.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.data.remote.dto.AuthResponse
import md.restaurant.app.databinding.FragmentLoginBinding
import md.restaurant.app.presentation.ui.profile.ProfileFragment
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener { performLogin() }
        binding.tvSwitchToRegister.setOnClickListener {
            (parentFragment as ProfileFragment).showRegister()
        }
    }

    private fun performLogin() {
        val email = binding.etEmail.text.toString().trim()
        val pass = binding.etPassword.text.toString()

        if (email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(requireContext(), "Заполните поля", Toast.LENGTH_SHORT).show()
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response: AuthResponse = withContext(Dispatchers.IO) {
                    Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthApiService::class.java)
                        .login(AuthRequest(email, pass))
                }

                AuthManager.saveAuth(requireContext(), response.token, response.user)
                (parentFragment as ProfileFragment).showMainProfile()
                Toast.makeText(requireContext(), "Вход успешен", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}