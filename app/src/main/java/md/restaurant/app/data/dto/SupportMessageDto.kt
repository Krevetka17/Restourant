package md.restaurant.app.data.remote.dto

import java.util.Date

data class SupportMessageDto(
    val _id: String,
    val message: String,
    val isFromSupport: Boolean = false,
    val timestamp: Date
)