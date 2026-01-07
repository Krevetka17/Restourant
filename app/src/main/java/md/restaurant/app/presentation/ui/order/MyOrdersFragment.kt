package md.restaurant.app.presentation.ui.profile.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentMyOrdersBinding
import md.restaurant.app.data.remote.order.OrderApiClient
import md.restaurant.app.utils.AuthManager
import java.text.SimpleDateFormat
import java.util.Locale

data class Order(
    val _id: String,
    val total: Double,
    val delivery: Boolean,
    val address: String?,
    val tableNumber: Int?,
    val reservationDate: String?,
    val startTime: String?,
    val endTime: String?,
    val status: String = "new",
    val rejectionReason: String? = null
)

class MyOrdersFragment : Fragment() {

    private var _binding: FragmentMyOrdersBinding? = null
    private val binding get() = _binding!!

    private val adapter = OrderAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackOrders.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOrders.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            loadOrders()
        }

        loadOrders()
    }

    private fun loadOrders() {
        val currentBinding = _binding ?: return  // Защита от краша

        currentBinding.swipeRefresh.isRefreshing = true
        val userId = AuthManager.getUser(requireContext())?.id

        if (userId == null) {
            currentBinding.tvEmpty.visibility = View.VISIBLE
            currentBinding.swipeRefresh.isRefreshing = false
            return
        }

        lifecycleScope.launch {
            try {
                val orders = OrderApiClient.api.getUserOrders(userId)
                if (_binding == null) return@launch  // Фрагмент уже уничтожен

                adapter.submitList(orders)
                currentBinding.tvEmpty.visibility = if (orders.isEmpty()) View.VISIBLE else View.GONE
            } catch (e: Exception) {
                e.printStackTrace()
                if (_binding == null) return@launch
                currentBinding.tvEmpty.text = "Ошибка загрузки заказов"
                currentBinding.tvEmpty.visibility = View.VISIBLE
            } finally {
                if (_binding != null) {
                    currentBinding.swipeRefresh.isRefreshing = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class OrderAdapter : androidx.recyclerview.widget.ListAdapter<Order, OrderViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : androidx.recyclerview.widget.DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order) = oldItem._id == newItem._id
        override fun areContentsTheSame(oldItem: Order, newItem: Order) = oldItem == newItem
    }
}

class OrderViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
    private val tvOrderId = view.findViewById<android.widget.TextView>(R.id.tv_order_id)
    private val tvDate = view.findViewById<android.widget.TextView>(R.id.tv_date)
    private val tvTime = view.findViewById<android.widget.TextView>(R.id.tv_time)
    private val tvTable = view.findViewById<android.widget.TextView>(R.id.tv_table)
    private val tvTotal = view.findViewById<android.widget.TextView>(R.id.tv_total)
    private val tvStatus = view.findViewById<android.widget.TextView>(R.id.tv_status)
    private val tvReason = view.findViewById<android.widget.TextView>(R.id.tv_reason)

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

    fun bind(order: Order) {
        tvOrderId.text = "Заказ №${order._id.takeLast(6)}"

        tvTotal.text = "Сумма: ${order.total} MDL"

        when (order.status) {
            "new" -> {
                tvStatus.text = "Ожидает подтверждения"
                tvStatus.setTextColor(0xFFFF9800.toInt())
                tvReason.visibility = View.GONE
            }
            "confirmed" -> {
                tvStatus.text = "Подтверждён"
                tvStatus.setTextColor(0xFF4CAF50.toInt())
                tvReason.visibility = View.GONE
            }
            "rejected" -> {
                tvStatus.text = "Отказан"
                tvStatus.setTextColor(0xFFF44336.toInt())
                tvReason.visibility = View.VISIBLE
                tvReason.text = "Причина: ${order.rejectionReason ?: "Не указана"}"
            }
            else -> {
                tvStatus.text = "Статус: ${order.status}"
                tvReason.visibility = View.GONE
            }
        }

        if (order.delivery) {
            tvDate.text = "Тип: Доставка"
            tvDate.visibility = View.VISIBLE

            tvTime.text = "Адрес: ${order.address ?: "Не указан"}"
            tvTime.visibility = View.VISIBLE

            tvTable.visibility = View.GONE
        } else if (order.tableNumber != null) {
            val parsedDate = order.reservationDate?.let {
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(it)
            }
            tvDate.text = "Дата: ${parsedDate?.let { sdfDate.format(it) } ?: order.reservationDate}"
            tvDate.visibility = View.VISIBLE

            val displayedEndTime = subtract30Minutes(order.endTime)
            tvTime.text = "Время: ${order.startTime ?: ""}${displayedEndTime?.let { " - $it" } ?: ""}"
            tvTime.visibility = View.VISIBLE

            tvTable.text = "Столик: ${order.tableNumber}"
            tvTable.visibility = View.VISIBLE
        } else {
            val parsedDate = order.reservationDate?.let {
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(it)
            }
            tvDate.text = "Дата: ${parsedDate?.let { sdfDate.format(it) } ?: order.reservationDate}"
            tvDate.visibility = View.VISIBLE

            tvTime.text = "Время прихода: ${order.startTime ?: ""}"
            tvTime.visibility = View.VISIBLE

            tvTable.visibility = View.GONE
        }
    }
}