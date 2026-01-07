package md.restaurant.app.presentation.ui.profile.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import md.restaurant.app.R
import md.restaurant.app.data.remote.admin.AdminApiClient
import md.restaurant.app.data.remote.dto.AdminOrder
import md.restaurant.app.databinding.FragmentAdminOrdersListBinding

class AdminOrdersListFragment : Fragment() {

    private var _binding: FragmentAdminOrdersListBinding? = null
    private val binding get() = _binding!!

    private val adapter = AdminOrderAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAdminOrdersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvOrders.layoutManager = LinearLayoutManager(requireContext())
        binding.rvOrders.adapter = adapter

        binding.swipeRefresh.setOnRefreshListener {
            loadPendingOrders()
        }

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        loadPendingOrders()
    }

    private fun loadPendingOrders() {
        binding.swipeRefresh.isRefreshing = true

        lifecycleScope.launch {
            try {
                val orders = AdminApiClient.api.getPendingOrders()
                adapter.submitList(orders)
                binding.tvEmpty.visibility = if (orders.isEmpty()) View.VISIBLE else View.GONE
            } catch (e: Exception) {
                e.printStackTrace()
                binding.tvEmpty.text = "Ошибка загрузки"
                binding.tvEmpty.visibility = View.VISIBLE
            } finally {
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}