package md.restaurant.app.data.remote.dto

data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val phone: String? = null,
    val isAdmin: Boolean = false
)