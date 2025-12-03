package md.restaurant.app.data.remote.dto

data class RegisterRequest(
    val name: String,
    val login: String? = null,
    val email: String,
    val phone: String? = null,
    val password: String
)