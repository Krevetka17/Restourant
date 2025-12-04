package md.restaurant.app.presentation.ui.profile.register

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
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.data.remote.dto.AuthResponse
import md.restaurant.app.data.remote.dto.RegisterRequest
import md.restaurant.app.databinding.FragmentRegisterBinding
import md.restaurant.app.presentation.ui.profile.ProfileFragment
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener { performRegister() }
        binding.tvSwitchToLogin.setOnClickListener {
            (parentFragment as ProfileFragment).showLogin()
        }
    }

    private fun performRegister() {
        val name = binding.etName.text.toString().trim()
        val login = binding.etLogin.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val pass = binding.etPassword.text.toString()
        val repeat = binding.etRepeatPassword.text.toString()

        if (pass != repeat) {
            Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            return
        }
        if (pass.length < 6) {
            Toast.makeText(requireContext(), "Пароль должен быть не менее 6 символов", Toast.LENGTH_SHORT).show()
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
                        .register(RegisterRequest(name, login, email, phone, pass))
                }

                AuthManager.saveAuth(requireContext(), response.token, response.user)
                (parentFragment as ProfileFragment).showMainProfile()
                Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_LONG).show()
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