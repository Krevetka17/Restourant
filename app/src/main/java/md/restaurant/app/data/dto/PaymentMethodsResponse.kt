package md.restaurant.app.data.remote.dto

data class PaymentMethodDto(
    val id: String,
    val cardNumber: String,
    val expiry: String,
    val brand: String?,
    val isDefault: Boolean = false
)

data class PaymentMethodsResponse(
    val success: Boolean,
    val paymentMethods: List<PaymentMethodDto>
)