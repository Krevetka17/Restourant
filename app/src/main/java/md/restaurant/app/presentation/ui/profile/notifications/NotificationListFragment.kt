package md.restaurant.app.presentation.ui.profile.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import md.restaurant.app.MainActivity
import md.restaurant.app.data.remote.AuthApiClient
import md.restaurant.app.databinding.FragmentNotificationListBinding

class NotificationListFragment : Fragment() {

    private var _binding: FragmentNotificationListBinding? = null
    private val binding get() = _binding!!

    private val adapter = NotificationAdapter { notificationId ->
        markNotificationAsRead(notificationId)
    }

    private val fragmentScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    companion object {
        fun newInstance(unread: Boolean) = NotificationListFragment().apply {
            arguments = Bundle().apply { putBoolean("unread", unread) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isUnread = arguments?.getBoolean("unread") ?: true

        binding.recyclerNotifications.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerNotifications.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            loadNotifications(isUnread)
        }

        loadNotifications(isUnread)
    }

    fun refreshNotifications() {
        val isUnread = arguments?.getBoolean("unread") ?: true
        loadNotifications(isUnread)
    }

    private fun loadNotifications(unreadOnly: Boolean) {
        val currentBinding = _binding ?: return

        currentBinding.swipeRefresh.isRefreshing = true

        fragmentScope.launch {
            try {
                val notifications = withContext(Dispatchers.IO) {
                    AuthApiClient.api.getNotifications()
                }

                Log.d("Notifications", "Получено уведомлений: ${notifications.size}")
                notifications.forEach {
                    Log.d("Notifications", "Уведомление: title=${it.title}, message=${it.message}, category=${it.category}, id=${it.id}")
                }

                val filtered = if (unreadOnly) {
                    notifications.filter { !it.isRead }
                } else {
                    notifications.filter { it.isRead }
                }

                if (_binding == null) return@launch

                if (filtered.isEmpty()) {
                    currentBinding.tvEmpty.isVisible = true
                    currentBinding.recyclerNotifications.isVisible = false
                } else {
                    currentBinding.tvEmpty.isVisible = false
                    currentBinding.recyclerNotifications.isVisible = true

                    val list = filtered.map {
                        NotificationItem(
                            id = it.id ?: "",
                            title = it.title,
                            message = it.message,
                            category = it.category ?: "Администрация",
                            date = it.createdAt.split("T").getOrNull(0) ?: "",
                            isRead = it.isRead
                        )
                    }
                    adapter.submitList(list)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                if (_binding != null) {
                    currentBinding.tvEmpty.text = "Ошибка загрузки"
                    currentBinding.tvEmpty.isVisible = true
                }
            } finally {
                if (_binding != null) {
                    currentBinding.swipeRefresh.isRefreshing = false
                }
            }
        }
    }

    private fun markNotificationAsRead(id: String) {
        fragmentScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    AuthApiClient.api.markAsRead(id)
                }
                if (response.isSuccessful) {
                    loadNotifications(arguments?.getBoolean("unread") ?: true)
                    (requireActivity() as? MainActivity)?.refreshNotificationBadge()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        fragmentScope.cancel()
    }
}