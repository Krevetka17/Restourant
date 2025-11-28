package md.restaurant.app.presentation.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import md.restaurant.app.databinding.ItemMenuBinding
import md.restaurant.app.data.remote.dto.MenuItemDto
import md.restaurant.app.utils.CartManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import md.restaurant.app.R
import android.graphics.Color
import android.view.ViewGroup.MarginLayoutParams
import androidx.coordinatorlayout.widget.CoordinatorLayout
import android.view.Gravity
import android.widget.FrameLayout

private fun Int.dpToPx(context: Context): Int =
    (this * context.resources.displayMetrics.density).toInt()

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

                // Создаём кастомный вид
                val customView = LayoutInflater.from(root.context)
                    .inflate(R.layout.snackbar_custom, null, false)

                customView.findViewById<TextView>(R.id.snackbar_text).text =
                    "Добавлено в корзину × $quantity"

                // Главный трюк — заставляем Snackbar вести себя как wrap_content
                Snackbar.make(root, "", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.TRANSPARENT)
                    .setAnchorView((root.context as? AppCompatActivity)?.findViewById(R.id.bottom_navigation))
                    .apply {
                        // Убираем всё стандартное
                        view.setBackgroundColor(Color.TRANSPARENT)
                        (view as ViewGroup).removeAllViews()

                        // ВАЖНО: оборачиваем наш view в контейнер с wrap_content
                        val wrapper = FrameLayout(root.context).apply {
                            layoutParams = FrameLayout.LayoutParams(
                                ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            addView(customView)
                        }

                        (view as ViewGroup).addView(wrapper)

                        // Принудительно центрируем по горизонтали и не даём растягиваться
                        val params = view.layoutParams
                        if (params is CoordinatorLayout.LayoutParams) {
                            params.width = ViewGroup.LayoutParams.WRAP_CONTENT
                            params.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                            params.bottomMargin = 100.dpToPx(root.context)
                        }
                        view.layoutParams = params
                    }
                    .show()
            }
        }
    }

    override fun getItemCount() = items.size
}