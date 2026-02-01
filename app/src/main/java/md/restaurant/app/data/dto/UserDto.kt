package md.restaurant.app.data.remote.dto

import com.google.gson.annotations.SerializedName
data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val phone: String? = null,
    val isAdmin: Boolean = false,
    @SerializedName("avatar") val avatar: String? = null,
    val paymentMethods: List<PaymentMethodDto>? = null,
    val stripeCustomerId: String? = null,
)