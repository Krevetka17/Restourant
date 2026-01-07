package md.restaurant.app.presentation.ui.profile.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentAdminPanelBinding
import md.restaurant.app.presentation.ui.profile.admin.AdminOrdersListFragment
import md.restaurant.app.presentation.ui.settings.AdminSupportTicketsFragment

class AdminPanelFragment : Fragment() {

    private var _binding: FragmentAdminPanelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminPanelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOrders.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_container, AdminOrdersListFragment())
                .addToBackStack("admin_orders_list")
                .commit()
        }

        binding.btnRequests.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_container, AdminRequestsListFragment())
                .addToBackStack("requests_list")
                .commit()
        }

        binding.btnSupportTickets.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_container, AdminSupportTicketsFragment())
                .addToBackStack("support_tickets")
                .commit()
        }

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}