package md.restaurant.app.presentation.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.data.remote.dto.RegisterRequest
import md.restaurant.app.databinding.FragmentProfileBinding
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import md.restaurant.app.data.remote.AuthApiService
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inf: LayoutInflater, cg: ViewGroup?, s: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inf, cg, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI()

        binding.tvSwitchToRegister.setOnClickListener { showRegisterForm() }
        binding.tvSwitchToLogin.setOnClickListener { showLoginForm() }

        binding.btnLogin.setOnClickListener { performLogin() }
        binding.btnRegister.setOnClickListener { performRegister() }
        binding.btnLogout.setOnClickListener {
            AuthManager.logout(requireContext())
            updateUI()
            Toast.makeText(requireContext(), "Вышли из аккаунта", Toast.LENGTH_SHORT).show()
        }

        binding.etPasswordReg.addTextChangedListener(passwordWatcher)
    }

    private fun showLoginForm() {
        binding.layoutLogin.isVisible = true
        binding.layoutRegister.isVisible = false
    }

    private fun showRegisterForm() {
        binding.layoutLogin.isVisible = false
        binding.layoutRegister.isVisible = true
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
                val response = withContext(Dispatchers.IO) {
                    // Временно создаём клиент только для auth (порт 5002)
                    val authRetrofit = Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val authService = authRetrofit.create(AuthApiService::class.java)
                    authService.login(AuthRequest(email, pass))
                }

                AuthManager.saveAuth(requireContext(), response.token, response.user)
                updateUI()
                Toast.makeText(requireContext(), "Успешный вход", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка входа: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performRegister() {
        val name = binding.etNameReg.text.toString().trim()
        val login = binding.etLoginReg.text.toString().trim()
        val email = binding.etEmailReg.text.toString().trim()
        val phone = binding.etPhoneReg.text.toString().trim()
        val pass = binding.etPasswordReg.text.toString()
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
                val response = withContext(Dispatchers.IO) {
                    // Тот же временный клиент на 5002
                    val authRetrofit = Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val authService = authRetrofit.create(AuthApiService::class.java)
                    authService.register(RegisterRequest(name, login, email, phone, pass))
                }

                AuthManager.saveAuth(requireContext(), response.token, response.user)
                updateUI()
                Toast.makeText(requireContext(), "Регистрация успешна", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Ошибка регистрации: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateUI() {
        val user = AuthManager.getUser(requireContext())
        if (user != null) {
            binding.groupLoggedIn.isVisible = true
            binding.groupLoggedOut.isVisible = false

            binding.tvUserName.text = user.name ?: "Пользователь"
            binding.tvUserEmail.text = user.email ?: ""

            binding.btnSupport.isVisible = user.isAdmin == true
        } else {
            binding.groupLoggedIn.isVisible = false
            binding.groupLoggedOut.isVisible = true
            showLoginForm()
        }
    }

    // === Проверка сложности пароля ===
    private val passwordWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val pass = s.toString()
            val strength = calculatePasswordStrength(pass)

            val bars = listOf(binding.bar1, binding.bar2, binding.bar3, binding.bar4)
            bars.forEach { it.setBackgroundColor(Color.parseColor("#DDDDDD")) }

            when (strength) {
                0 -> binding.tvStrength.text = getString(md.restaurant.app.R.string.password_too_weak)
                1 -> {
                    binding.tvStrength.text = getString(md.restaurant.app.R.string.password_weak)
                    bars[0].setBackgroundColor(Color.RED)
                }
                2 -> {
                    binding.tvStrength.text = getString(md.restaurant.app.R.string.password_medium)
                    bars.take(2).forEach { it.setBackgroundColor(Color.parseColor("#FF9800")) }
                }
                3 -> {
                    binding.tvStrength.text = getString(md.restaurant.app.R.string.password_strong)
                    bars.take(3).forEach { it.setBackgroundColor(Color.YELLOW) }
                }
                4 -> {
                    binding.tvStrength.text = getString(md.restaurant.app.R.string.password_very_strong)
                    bars.forEach { it.setBackgroundColor(Color.GREEN) }
                }
            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    private fun calculatePasswordStrength(password: String): Int {
        var score = 0
        if (password.length >= 8) score++
        if (password.any { it.isDigit() }) score++
        if (password.any { it.isUpperCase() }) score++
        if (password.any { it.isLowerCase() }) score++
        if (password.any { "!@#\$%^&*()_+-=[]{}|;':\",./<>?".contains(it) }) score++
        return score.coerceAtMost(4)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}