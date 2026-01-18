package md.restaurant.app.presentation.ui.dish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import md.restaurant.app.R
import md.restaurant.app.data.remote.dto.MenuItemDto
import md.restaurant.app.databinding.FragmentDishDetailBinding
import md.restaurant.app.presentation.ui.home.HomeFragment   // ← добавь эту строку
import md.restaurant.app.utils.CartManager

class DishDetailFragment : Fragment() {

    private var _binding: FragmentDishDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuItem: MenuItemDto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menuItem = arguments?.getParcelable<MenuItemDto>("menuItem")
            ?: throw IllegalStateException("MenuItem не передан")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDishDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            tvName.text = menuItem.name
            tvDescription.text = menuItem.description
            tvPrice.text = "${menuItem.price} MDL"
            tvRating.text = "★ ${menuItem.rating}"
            tvIngredients.text = "Состав: ${menuItem.ingredients.joinToString(", ")}"
            tvAllergens.text = if (menuItem.allergens.isNotEmpty())
                "Аллергены: ${menuItem.allergens.joinToString(", ")}"
            else "Аллергены отсутствуют"

            Glide.with(ivDish)
                .load(menuItem.imageUrl)
                .placeholder(R.drawable.ic_photo_missing)
                .error(R.drawable.ic_photo_missing)
                .centerCrop()
                .into(ivDish)

            btnAddToCart.setOnClickListener {
                CartManager.addItem(requireContext(), menuItem)
                Snackbar.make(root, "Добавлено в корзину", Snackbar.LENGTH_SHORT).show()
            }

            btnBack.setOnClickListener {
                (parentFragment as? HomeFragment)?.hideDishDetail()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}