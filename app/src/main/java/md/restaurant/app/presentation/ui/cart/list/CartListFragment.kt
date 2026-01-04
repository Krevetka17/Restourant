package md.restaurant.app.presentation.ui.cart.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import md.restaurant.app.databinding.FragmentCartListBinding
import md.restaurant.app.utils.CartManager
import md.restaurant.app.presentation.ui.cart.CartFragment

class CartListFragment : Fragment() {

    private var _binding: FragmentCartListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: md.restaurant.app.presentation.ui.cart.CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCartListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()
        setupRecyclerView()
        updateUI()

        binding.btnCheckout.setOnClickListener {
            val cart = CartManager.getCart(context)
            if (cart.isEmpty()) {
                Snackbar.make(binding.root, "Корзина пуста", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            (parentFragment as CartFragment).showPayment()
        }
    }

    private fun setupRecyclerView() {
        val context = requireContext()
        adapter = md.restaurant.app.presentation.ui.cart.CartAdapter(
            items = CartManager.getCart(context).toMutableList(),
            onQuantityChange = { itemId, newQty ->
                CartManager.updateQuantity(context, itemId, newQty)
                updateTotal()
            },
            onRemove = { itemId ->
                CartManager.removeItem(context, itemId)
                updateTotal()
                updateUI()
            }
        )
        binding.rvCart.layoutManager = LinearLayoutManager(context)
        binding.rvCart.adapter = adapter
    }

    private fun updateUI() {
        val context = requireContext()
        val cart = CartManager.getCart(context)
        adapter.updateItems(cart)
        updateTotal()

        binding.tvEmpty.visibility = if (cart.isEmpty()) View.VISIBLE else View.GONE
        binding.btnCheckout.visibility = if (cart.isEmpty()) View.GONE else View.VISIBLE
    }

    private fun updateTotal() {
        binding.tvTotal.text = "Итого: ${CartManager.getTotal(requireContext())} MDL"
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}