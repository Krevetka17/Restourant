package md.restaurant.app.presentation.ui.profile.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.MainActivity
import md.restaurant.app.data.remote.AuthApiClient
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.databinding.FragmentNotificationListBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NotificationListFragment : Fragment() {

    private var _binding: FragmentNotificationListBinding? = null
    private val binding get() = _binding!!
    private val adapter = NotificationAdapter { notificationId ->
        markNotificationAsRead(notificationId)
    }

    private fun markNotificationAsRead(id: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    AuthApiClient.api.markAsRead(id)
                }
                if (response.isSuccessful) {
                    loadNotifications(arguments?.getBoolean("unread") ?: true)
                    // Обновляем бейдж в MainActivity и в профиле
                    (requireActivity() as? MainActivity)?.refreshNotificationBadge()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

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

        loadNotifications(isUnread)
    }

    private fun loadNotifications(unreadOnly: Boolean) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val notifications = withContext(Dispatchers.IO) {
                    AuthApiClient.api.getNotifications()
                }

                // Логируем для дебага
                println("Уведомления получено: ${notifications.size}")

                val filtered = if (unreadOnly) {
                    notifications.filter { !it.isRead }
                } else {
                    notifications.filter { it.isRead }
                }

                if (filtered.isEmpty()) {
                    binding.tvEmpty.isVisible = true
                    binding.recyclerNotifications.isVisible = false
                } else {
                    binding.tvEmpty.isVisible = false
                    binding.recyclerNotifications.isVisible = true

                    val list = filtered.map {
                        NotificationItem(
                            id = it.id,
                            title = it.title,
                            message = it.message,
                            category = it.category,
                            date = it.createdAt.split("T")[0],
                            isRead = it.isRead
                        )
                    }
                    adapter.submitList(list)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                binding.tvEmpty.text = "Ошибка загрузки: ${e.message}"
                binding.tvEmpty.isVisible = true
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}