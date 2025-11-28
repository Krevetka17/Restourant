// presentation/ui/cart/CartFragment.kt
package md.restaurant.app.presentation.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import md.restaurant.app.databinding.FragmentCartBinding
import md.restaurant.app.utils.CartManager

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CartAdapter(
            items = CartManager.getCart(requireContext()).toMutableList(),  // ← toMutableList()!
            onQuantityChange = { id, qty ->
                CartManager.updateQuantity(requireContext(), id, qty)
                updateTotal()
            },
            onRemove = { id ->
                CartManager.removeItem(requireContext(), id)
                updateTotal()
            }
        )

        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCart.adapter = adapter

        updateTotal()
    }

    private fun updateTotal() {
        val total = CartManager.getTotal(requireContext())
        binding.tvTotal.text = "Итого: ${total} MDL"
    }

    override fun onResume() {
        super.onResume()
        adapter.updateItems(CartManager.getCart(requireContext()))
        updateTotal()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}