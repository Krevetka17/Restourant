package md.restaurant.app.presentation.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentCartBinding
import md.restaurant.app.presentation.ui.cart.list.CartListFragment
import md.restaurant.app.presentation.ui.order.OrderPaymentFragment

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            showCartList()
        }
    }

    fun showCartList() {
        childFragmentManager.commit {
            replace(R.id.cart_container, CartListFragment())
        }
    }

    fun showPayment() {
        childFragmentManager.commit {
            replace(R.id.cart_container, OrderPaymentFragment())
            addToBackStack("payment")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}