package md.restaurant.app.presentation.ui.profile.admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import md.restaurant.app.data.remote.admin.AdminApiClient
import md.restaurant.app.data.remote.dto.AdminOrder
import md.restaurant.app.databinding.ItemAdminOrderBinding
import java.text.SimpleDateFormat
import java.util.*

class AdminOrderAdapter : ListAdapter<AdminOrder, AdminOrderViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminOrderViewHolder {
        val binding = ItemAdminOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdminOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdminOrderViewHolder, position: Int) {
        holder.bind(getItem(position), this)
    }

    class DiffCallback : DiffUtil.ItemCallback<AdminOrder>() {
        override fun areItemsTheSame(oldItem: AdminOrder, newItem: AdminOrder) = oldItem._id == newItem._id
        override fun areContentsTheSame(oldItem: AdminOrder, newItem: AdminOrder) = oldItem == newItem
    }
}

class AdminOrderViewHolder(private val binding: ItemAdminOrderBinding) : RecyclerView.ViewHolder(binding.root) {

    private val sdfDate = SimpleDateFormat("dd MMMM", Locale("ru"))

    private fun subtract30Minutes(time: String?): String? {
        if (time == null) return null
        val (h, m) = time.split(":").map { it.toInt() }
        var totalMin = h * 60 + m - 30
        if (totalMin < 0) totalMin += 1440
        val endH = totalMin / 60
        val endM = totalMin % 60
        return String.format("%02d:%02d", endH, endM)
    }

    fun bind(order: AdminOrder, adapter: AdminOrderAdapter) {
        binding.tvOrderId.text = "Заказ №${order._id.takeLast(6)}"
        binding.tvTotal.text = "Сумма: ${order.total} MDL"

        // Показ оплаты
        binding.tvType.text = if (order.paid) "Оплачено онлайн" else "Не оплачено"
        binding.tvType.setTextColor(
            if (order.paid) 0xFF4CAF50.toInt() else 0xFFF44336.toInt()
        )

        if (order.delivery) {
            binding.tvType.visibility = View.VISIBLE
            binding.tvAddress.visibility = View.VISIBLE
            binding.tvAddress.text = "Адрес: ${order.address ?: "Не указан"}"
            binding.tvDate.visibility = View.GONE
            binding.tvTime.visibility = View.GONE
            binding.tvTable.visibility = View.GONE
        } else if (order.tableNumber != null) {
            binding.tvType.visibility = View.VISIBLE
            binding.tvAddress.visibility = View.GONE

            if (order.reservationDate != null) {
                val parsed = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(order.reservationDate)
                binding.tvDate.visibility = View.VISIBLE
                binding.tvDate.text = "Дата: ${parsed?.let { sdfDate.format(it) } ?: order.reservationDate}"
            } else {
                binding.tvDate.visibility = View.GONE
            }

            val displayedEnd = subtract30Minutes(order.endTime)
            binding.tvTime.visibility = View.VISIBLE
            binding.tvTime.text = "Время: ${order.startTime ?: ""}${displayedEnd?.let { " - $it" } ?: ""}"

            binding.tvTable.visibility = View.VISIBLE
            binding.tvTable.text = "Столик: ${order.tableNumber}"
        } else {
            binding.tvType.visibility = View.VISIBLE
            binding.tvAddress.visibility = View.GONE

            if (order.reservationDate != null) {
                val parsed = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(order.reservationDate)
                binding.tvDate.visibility = View.VISIBLE
                binding.tvDate.text = "Дата: ${parsed?.let { sdfDate.format(it) } ?: order.reservationDate}"
            } else {
                binding.tvDate.visibility = View.GONE
            }

            binding.tvTime.visibility = View.VISIBLE
            binding.tvTime.text = "Время прихода: ${order.startTime ?: ""}"

            binding.tvTable.visibility = View.GONE
        }

        val itemsText = order.items.joinToString("\n") { item ->
            val name = item.name ?: "Неизвестное блюдо"
            val quantity = item.quantity
            val price = item.price
            "$quantity × $name — ${price * quantity} MDL"
        }
        binding.tvItems.text = "Блюда:\n$itemsText"

        binding.btnConfirm.setOnClickListener {
            (binding.root.context as? androidx.fragment.app.FragmentActivity)?.lifecycleScope?.launch {
                try {
                    val response = AdminApiClient.api.confirmOrder(order._id)
                    if (response.isSuccessful) {
                        val newList = adapter.currentList.toMutableList()
                        newList.remove(order)
                        adapter.submitList(newList)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        binding.btnReject.setOnClickListener {
            val reason = binding.etReason.text.toString().trim()
            if (reason.isEmpty()) {
                binding.etReason.error = "Укажите причину"
                return@setOnClickListener
            }

            (binding.root.context as? androidx.fragment.app.FragmentActivity)?.lifecycleScope?.launch {
                try {
                    val response = AdminApiClient.api.rejectOrder(order._id, mapOf("reason" to reason))
                    if (response.isSuccessful) {
                        val newList = adapter.currentList.toMutableList()
                        newList.remove(order)
                        adapter.submitList(newList)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}