package md.restaurant.app.presentation.ui.profile.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentAdminPanelBinding

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

        binding.btnRequests.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_container, AdminRequestsListFragment())
                .addToBackStack("requests_list")
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