package md.restaurant.app.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.databinding.ItemMenuBinding
import md.restaurant.app.data.remote.dto.MenuItemDto
import md.restaurant.app.utils.CartManager

class MenuAdapter(
    private val items: List<MenuItemDto>
) : RecyclerView.Adapter<MenuAdapter.VH>() {

    inner class VH(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        var quantity = 1

        holder.binding.apply {
            tvName.text = item.name
            tvDescription.text = item.description
            tvPrice.text = "${item.price} MDL"
            tvQuantity.text = "1"

            btnPlus.setOnClickListener {
                quantity++
                tvQuantity.text = quantity.toString()
            }

            btnMinus.setOnClickListener {
                if (quantity > 1) {
                    quantity--
                    tvQuantity.text = quantity.toString()
                }
            }

            btnAddToCart.setOnClickListener {
                repeat(quantity) {
                    CartManager.addItem(root.context, item)
                }
                // Можно показать Snackbar
            }
        }
    }

    override fun getItemCount() = items.size
}