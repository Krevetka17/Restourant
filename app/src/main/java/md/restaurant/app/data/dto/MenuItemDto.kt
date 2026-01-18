package md.restaurant.app.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItemDto(
    val _id: String? = null,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageUrl: String? = null,
    val ingredients: List<String> = emptyList(),
    val allergens: List<String> = emptyList(),
    val additives: List<String> = emptyList(),
    val rating: Float = 4.5f,
    val calories: Int? = null,
    val protein: Float? = null,
    val fat: Float? = null,
    val carbs: Float? = null
) : Parcelable