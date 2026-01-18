package md.restaurant.app.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import md.restaurant.app.R
import md.restaurant.app.data.remote.dto.MenuItemDto
import md.restaurant.app.databinding.ItemMenuHorizontalBinding

class CategoryAdapter(
    private val items: List<MenuItemDto>,
    private val onClick: (MenuItemDto) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.VH>() {

    inner class VH(val binding: ItemMenuHorizontalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemMenuHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.binding.apply {
            tvName.text = item.name
            tvPrice.text = "${item.price} MDL"

            Glide.with(root)
                .load(item.imageUrl)
                .placeholder(R.drawable.ic_photo_missing)
                .error(R.drawable.ic_photo_missing)
                .centerCrop()
                .into(ivFood)

            root.setOnClickListener { onClick(item) }
        }
    }

    override fun getItemCount() = items.size
}