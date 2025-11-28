// presentation/ui/cart/CartAdapter.kt
package md.restaurant.app.presentation.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.databinding.ItemCartBinding
import md.restaurant.app.domain.model.CartItem

class CartAdapter(
    private var items: MutableList<CartItem>,
    private val onQuantityChange: (String, Int) -> Unit,
    private val onRemove: (String) -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartItem = items[position]
        val item = cartItem.menuItem

        holder.binding.apply {
            tvName.text = item.name
            tvPrice.text = "${item.price * cartItem.quantity} MDL"
            etQuantity.setText(cartItem.quantity.toString())

            btnMinus.setOnClickListener {
                if (cartItem.quantity > 1) {
                    cartItem.quantity--
                    etQuantity.setText(cartItem.quantity.toString())
                    onQuantityChange(item._id, cartItem.quantity)
                } else {
                    removeItem(position)
                }
            }

            btnPlus.setOnClickListener {
                cartItem.quantity++
                etQuantity.setText(cartItem.quantity.toString())
                onQuantityChange(item._id, cartItem.quantity)
            }

            btnRemove.setOnClickListener {
                removeItem(position)
            }
        }
    }

    // ← МГНОВЕННОЕ УДАЛЕНИЕ!
    private fun removeItem(position: Int) {
        val itemId = items[position].menuItem._id
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
        onRemove(itemId)
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<CartItem>) {
        items = newItems.toMutableList()
        notifyDataSetChanged()
    }
}