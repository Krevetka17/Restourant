package md.restaurant.app.data.remote.dto

data class CreateOrderRequest(
    val userId: String,
    val items: List<CartItemRequest>,
    val total: Double,
    val delivery: Boolean,
    val address: String? = null,
    val tableNumber: Int? = null,
    val reservationDate: String? = null,
    val startTime: String? = null,
    val endTime: String? = null
)

data class CartItemRequest(
    val menuItemId: String,
    val quantity: Int,
    val price: Double
)

data class OrderResponse(
    val success: Boolean,
    val orderId: String? = null,
    val message: String? = null
)