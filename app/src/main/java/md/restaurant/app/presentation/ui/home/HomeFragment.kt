// presentation/ui/home/HomeFragment.kt
package md.restaurant.app.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.*
import md.restaurant.app.data.remote.ApiClient
import md.restaurant.app.databinding.FragmentHomeBinding
import md.restaurant.app.utils.CartManager

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMenu.layoutManager = GridLayoutManager(requireContext(), 2)

        loadMenuFromServer()
    }

    private fun loadMenuFromServer() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val menu = withContext(Dispatchers.IO) {
                    ApiClient.api.getMenu()
                }
                binding.rvMenu.adapter = MenuAdapter(menu)
            } catch (e: Exception) {
                e.printStackTrace()
                // Можно показать ошибку
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}