package md.restaurant.app.data.remote.dto

data class MenuItemDto(
    val _id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val imageUrl: String? = null
)