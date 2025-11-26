package md.restaurant.app.domain.model

data class MenuItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String // food, drinks, desserts
)