package md.restaurant.app.presentation.ui.profile

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.R
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.databinding.FragmentProfileBinding
import md.restaurant.app.presentation.ui.profile.admin.AdminPanelFragment
import md.restaurant.app.presentation.ui.profile.edit.EditProfileFragment
import md.restaurant.app.presentation.ui.profile.login.LoginFragment
import md.restaurant.app.presentation.ui.profile.main.MainProfileFragment
import md.restaurant.app.presentation.ui.profile.notifications.NotificationsFragment
import md.restaurant.app.presentation.ui.profile.register.RegisterFragment
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private val refreshInterval = 20_000L // 20 секунд

    private val refreshRunnable = object : Runnable {
        override fun run() {
            if (isVisible && AuthManager.isLoggedIn(requireContext())) {
                refreshUserData()
            }
            handler.postDelayed(this, refreshInterval)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (AuthManager.isLoggedIn(requireContext())) {
            showMainProfile()
            refreshUserData() // Сразу обновляем
        } else {
            showLogin()
        }
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(refreshRunnable, refreshInterval)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(refreshRunnable)
    }

    private fun refreshUserData() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val user = withContext(Dispatchers.IO) {
                    Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:5002/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(AuthApiService::class.java)
                        .getCurrentUser()
                }
                AuthManager.saveAuth(requireContext(), AuthManager.getToken(requireContext())!!, user)

                // Обновляем текущий фрагмент
                (childFragmentManager.findFragmentById(R.id.profile_container) as? MainProfileFragment)
                    ?.updateUserInfo()
            } catch (e: Exception) {
                // Игнорируем ошибки
            }
        }
    }

    fun showLogin() {
        childFragmentManager.commit {
            replace(R.id.profile_container, LoginFragment())
        }
    }

    fun showRegister() {
        childFragmentManager.commit {
            replace(R.id.profile_container, RegisterFragment())
        }
    }

    fun showMainProfile() {
        childFragmentManager.commit {
            replace(R.id.profile_container, MainProfileFragment())
        }
    }

    fun showEditProfile() {
        childFragmentManager.commit {
            replace(R.id.profile_container, EditProfileFragment())
            addToBackStack("edit_profile")
        }
    }

    fun showAdminPanel() {
        childFragmentManager.commit {
            replace(R.id.profile_container, AdminPanelFragment())
            addToBackStack("admin_panel")
        }
    }

    fun showNotifications() {
        childFragmentManager.commit {
            replace(R.id.profile_container, NotificationsFragment())
            addToBackStack("notifications")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}