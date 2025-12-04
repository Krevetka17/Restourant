package md.restaurant.app.presentation.ui.profile.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.databinding.ItemNotificationBinding

class NotificationAdapter(
    private val onNotificationRead: (String) -> Unit
) : ListAdapter<NotificationItem, NotificationAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onNotificationRead)
    }

    inner class ViewHolder(private val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NotificationItem, onMarkAsRead: (String) -> Unit) {
            binding.tvCategory.text = item.category
            binding.tvTitle.text = item.title
            binding.tvMessage.text = item.message
            binding.tvDate.text = item.date

            // Показываем только зелёную галочку, если НЕ прочитано
            binding.btnMarkAsRead.isVisible = !item.isRead

            // Клик по галочке — помечаем как прочитанное
            binding.btnMarkAsRead.setOnClickListener {
                onMarkAsRead(item.id)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NotificationItem>() {
        override fun areItemsTheSame(old: NotificationItem, new: NotificationItem) = old.id == new.id
        override fun areContentsTheSame(old: NotificationItem, new: NotificationItem) = old == new
    }
}