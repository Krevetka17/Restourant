package md.restaurant.app.presentation.ui.profile.notifications

data class NotificationItem(
    val id: String,
    val title: String,
    val message: String,
    val category: String,
    val date: String,
    val isRead: Boolean
)