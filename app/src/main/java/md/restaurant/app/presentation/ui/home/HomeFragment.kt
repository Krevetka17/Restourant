package md.restaurant.app.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import md.restaurant.app.R
import md.restaurant.app.data.remote.ApiClient
import md.restaurant.app.data.remote.dto.MenuItemDto
import md.restaurant.app.databinding.FragmentHomeBinding
import md.restaurant.app.databinding.ItemCategorySectionBinding
import md.restaurant.app.presentation.ui.dish.DishDetailFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val categories = mutableListOf<String>()
    private val menuByCategory = mutableMapOf<String, List<MenuItemDto>>()
    private var allItems: List<MenuItemDto> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMenu()

        binding.searchEditText.setOnEditorActionListener { _, _, _ ->
            performSearch(binding.searchEditText.text.toString().trim())
            true
        }

        binding.searchLayout.setEndIconOnClickListener {
            performSearch(binding.searchEditText.text.toString().trim())
        }
    }

    private fun loadMenu() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val menu = withContext(Dispatchers.IO) { ApiClient.api.getMenu() }
                allItems = menu
                groupByCategories(menu)
                buildUI()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun groupByCategories(menu: List<MenuItemDto>) {
        menuByCategory.clear()
        categories.clear()
        menu.groupBy { it.category }.forEach { (cat, items) ->
            categories.add(cat)
            menuByCategory[cat] = items
        }
    }

    private fun buildUI() {
        binding.categoryChipsContainer.removeAllViews()
        categories.forEachIndexed { index, cat ->
            val chip = com.google.android.material.chip.Chip(requireContext()).apply {
                text = cat.replaceFirstChar { it.uppercase() }
                isCheckable = false  // убрали галочку и выделение
                setOnClickListener {
                    scrollToCategory(index)
                }
            }
            binding.categoryChipsContainer.addView(chip)
        }

        binding.categoriesContainer.removeAllViews()
        categories.forEach { cat ->
            val sectionBinding = ItemCategorySectionBinding.inflate(
                LayoutInflater.from(requireContext()), binding.categoriesContainer, false
            )

            sectionBinding.tvCategoryTitle.text = cat.replaceFirstChar { it.uppercase() }

            sectionBinding.rvCategoryItems.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = CategoryAdapter(menuByCategory[cat] ?: emptyList()) { item ->
                    showDishDetail(item)
                }
            }

            binding.categoriesContainer.addView(sectionBinding.root)
        }
    }

    private fun scrollToCategory(index: Int) {
        val categoryView = binding.categoriesContainer.getChildAt(index) ?: return
        val location = IntArray(2)
        categoryView.getLocationOnScreen(location)
        val scrollY = location[1] - binding.menuScroll.top
        binding.menuScroll.smoothScrollTo(0, scrollY - 100)
    }

    private fun performSearch(query: String) {
        if (query.isEmpty()) {
            // при пустом поиске — возвращаем всё
            groupByCategories(allItems)
            buildUI()
            return
        }

        val filtered = allItems.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.description.contains(query, ignoreCase = true)
        }

        if (filtered.isEmpty()) {
            binding.categoriesContainer.removeAllViews()
            return
        }

        val filteredByCat = filtered.groupBy { it.category }
        categories.clear()
        menuByCategory.clear()

        filteredByCat.forEach { (cat, items) ->
            categories.add(cat)
            menuByCategory[cat] = items
        }

        buildUI()
    }

    private fun showDishDetail(item: MenuItemDto) {
        val detailFragment = DishDetailFragment().apply {
            arguments = Bundle().apply { putParcelable("menuItem", item) }
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.dish_detail_container, detailFragment)
            .addToBackStack("dish_detail")
            .commit()

        binding.dishDetailContainer.visibility = View.VISIBLE
        binding.menuScroll.visibility = View.GONE
    }

    fun hideDishDetail() {
        binding.dishDetailContainer.visibility = View.GONE
        binding.menuScroll.visibility = View.VISIBLE
        childFragmentManager.popBackStack("dish_detail", 0)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}