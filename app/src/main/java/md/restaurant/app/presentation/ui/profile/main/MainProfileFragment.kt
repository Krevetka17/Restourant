package md.restaurant.app.presentation.ui.profile.main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import md.restaurant.app.R
import md.restaurant.app.data.remote.AuthApiClient
import md.restaurant.app.databinding.FragmentMainProfileBinding
import md.restaurant.app.presentation.ui.profile.ProfileFragment
import md.restaurant.app.utils.AuthManager
import md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainProfileFragment : Fragment() {

    private var _binding: FragmentMainProfileBinding? = null
    private val binding get() = _binding!!
    private val badgeViewModel: NotificationBadgeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSwipeRefresh()
        updateUserInfo()
        updateAdminButton() // сразу проверяем
        setupButtons()
        observeNotificationBadge()
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            refreshAllData()
        }

        binding.swipeRefresh.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
    }

    private fun setupButtons() {
        binding.btnEditProfile.setOnClickListener {
            (parentFragment as ProfileFragment).showEditProfile()
        }

        binding.btnNotifications.setOnClickListener {
            (parentFragment as ProfileFragment).showNotifications()
        }

        binding.btnMyOrders.setOnClickListener {
            (parentFragment as ProfileFragment).showMyOrders()
        }

        binding.btnAdminPanel.setOnClickListener {
            (parentFragment as ProfileFragment).showAdminPanel()
        }

        binding.btnLogout.setOnClickListener {
            AuthManager.logout(requireContext())
            (parentFragment as ProfileFragment).showLogin()
        }

        binding.btnCopyId.setOnClickListener {
            val userId = AuthManager.getUser(requireContext())?.id ?: return@setOnClickListener
            val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("User ID", userId)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(), "ID скопирован!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateAdminButton() {
        val isAdmin = AuthManager.getUser(requireContext())?.isAdmin == true
        binding.btnAdminPanel.isVisible = isAdmin
    }

    private fun observeNotificationBadge() {
        badgeViewModel.hasUnread.observe(viewLifecycleOwner) { hasUnread ->
            binding.btnNotifications.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0, 0,
                if (hasUnread) R.drawable.ic_notification_badge else 0,
                0
            )
        }
    }

    private fun refreshAllData() {
        binding.swipeRefresh.isRefreshing = true

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val freshUser = withContext(Dispatchers.IO) {
                    AuthApiClient.api.getCurrentUser()
                }

                AuthManager.saveAuth(requireContext(), AuthManager.getToken(requireContext())!!, freshUser)

                updateUserInfo()
                updateAdminButton()
                badgeViewModel.checkUnreadNotifications()

                // Обновляем уведомления
                (parentFragment as? ProfileFragment)?.refreshNotifications()

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Нет сети", Toast.LENGTH_SHORT).show()
            } finally {
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    fun updateUserInfo() {
        val user = AuthManager.getUser(requireContext()) ?: return

        binding.tvUserName.text = user.name ?: "Пользователь"
        binding.tvUserEmail.text = user.email ?: ""
        binding.tvUserId.text = "ID: ${user.id}"

        val avatarBase64 = AuthManager.getAvatarBase64(requireContext())
        if (avatarBase64 != null) {
            try {
                val bitmap = base64ToBitmap(avatarBase64)
                binding.ivAvatar.setImageBitmap(bitmap)
            } catch (e: Exception) {
                binding.ivAvatar.setImageResource(R.drawable.ic_default_user)
            }
        } else {
            binding.ivAvatar.setImageResource(R.drawable.ic_default_user)
        }

        updateAdminButton() // на всякий случай
    }

    private fun base64ToBitmap(base64: String): android.graphics.Bitmap {
        val bytes = Base64.decode(base64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}