package md.restaurant.app.data.remote.dto

data class AdminOrderItem(
    val menuItemId: String,
    val name: String,
    val quantity: Int,
    val price: Double
)

data class AdminOrder(
    val _id: String,
    val total: Double,
    val delivery: Boolean,
    val address: String?,
    val tableNumber: Int?,
    val reservationDate: String?,
    val startTime: String?,
    val endTime: String?,
    val status: String = "new",
    val rejectionReason: String? = null,
    val items: List<AdminOrderItem>
)