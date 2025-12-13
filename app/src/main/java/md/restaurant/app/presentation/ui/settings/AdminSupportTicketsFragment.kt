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
import java.text.SimpleDateFormat
import java.util.Locale

class AdminSupportTicketsFragment : Fragment() {

    private lateinit var rvTickets: RecyclerView
    private val adapter = AdminTicketsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_support_tickets, container, false)

        rvTickets = view.findViewById(R.id.rv_tickets)
        rvTickets.layoutManager = LinearLayoutManager(requireContext())
        rvTickets.adapter = adapter

        view.findViewById<View>(R.id.btn_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        loadTickets()

        return view
    }

    private fun loadTickets() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tickets = SupportApiClient.api.getAllTickets()
                withContext(Dispatchers.Main) {
                    adapter.setData(tickets)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    inner class AdminTicketsAdapter : RecyclerView.Adapter<AdminTicketsAdapter.ViewHolder>() {

        private val tickets = mutableListOf<TicketSummaryDto>()

        fun setData(newTickets: List<TicketSummaryDto>) {
            tickets.clear()
            tickets.addAll(newTickets)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_admin_ticket, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val ticket = tickets[position]
            holder.bind(ticket)
            holder.itemView.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.profile_container, AdminSupportChatFragment.newInstance(ticket.ticketId))
                    .addToBackStack("admin_chat")
                    .commit()
            }
        }

        override fun getItemCount() = tickets.size

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val tvUserName: TextView = itemView.findViewById(R.id.tv_user_name) // изменил id
            private val tvPreview: TextView = itemView.findViewById(R.id.tv_preview)
            private val tvDate: TextView = itemView.findViewById(R.id.tv_date)

            private val dateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

            fun bind(ticket: TicketSummaryDto) {
                tvUserName.text = ticket.userName ?: "Неизвестно"
                tvPreview.text = ticket.lastMessage
                tvDate.text = dateFormat.format(ticket.lastTimestamp)
            }
        }
    }
}