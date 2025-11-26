package md.restaurant.app.data.remote.dto

data class AuthRequest(
    val email: String,
    val password: String,
    val name: String? = null,
    val phone: String? = null
)