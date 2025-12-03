package md.restaurant.app.data.remote.dto

data class AuthResponse(
    val token: String,
    val user: UserDto
)