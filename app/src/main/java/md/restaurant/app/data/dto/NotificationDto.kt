package md.restaurant.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NotificationDto(
    @SerializedName("_id") val id: String,
    val title: String,
    val message: String,
    val category: String,
    val isRead: Boolean,
    val createdAt: String
)