package md.restaurant.app.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.R
import md.restaurant.app.data.remote.SupportApiClient
import md.restaurant.app.data.remote.dto.TicketSummaryDto
import md.restaurant.app.utils.AuthManager
import md.restaurant.app.RestaurantApp
import org.json.JSONObject
import android.util.Base64
import java.text.SimpleDateFormat
import java.util.Locale

class SupportHistoryFragment : Fragment() {

    private lateinit var rvHistory: RecyclerView
    private val adapter = HistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_support_history, container, false)

        rvHistory = view.findViewById(R.id.rv_history)
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
        rvHistory.adapter = adapter

        view.findViewById<View>(R.id.btn_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        loadHistory()

        return view
    }

    private fun loadHistory() {
        val token = AuthManager.getToken(RestaurantApp.instance)
        var userId: String = "unknown"
        if (!token.isNullOrBlank()) {
            try {
                val payload = token.split(".")[1]
                val decoded = String(Base64.decode(payload, Base64.URL_SAFE))
                userId = JSONObject(decoded).getString("userId")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tickets = SupportApiClient.api.getUserTickets(userId)
                withContext(Dispatchers.Main) {
                    adapter.setData(tickets.filter { it.ticketId != null })
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // Ошибка
                }
            }
        }
    }

    inner class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

        private val tickets = mutableListOf<TicketSummaryDto>()

        fun setData(newTickets: List<TicketSummaryDto>) {
            tickets.clear()
            tickets.addAll(newTickets)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_history_ticket, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val ticket = tickets[position]
            holder.bind(ticket)
            holder.itemView.setOnClickListener {
                ticket.ticketId?.let { id ->
                    (parentFragment as SettingsFragment).showSpecificSupportChat(id)
                }
            }
        }

        override fun getItemCount() = tickets.size

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val tvPreview: TextView = itemView.findViewById(R.id.tv_preview)
            private val tvDate: TextView = itemView.findViewById(R.id.tv_date)

            private val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

            fun bind(ticket: TicketSummaryDto) {
                tvPreview.text = ticket.lastMessage
                tvDate.text = dateFormat.format(ticket.lastTimestamp)
            }
        }
    }
}