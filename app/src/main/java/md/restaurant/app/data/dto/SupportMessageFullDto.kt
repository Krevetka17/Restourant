package md.restaurant.app.data.remote.dto

data class SupportMessageFullDto(
    val _id: String,
    val message: String,
    val isFromSupport: Boolean,
    val timestamp: java.util.Date
)