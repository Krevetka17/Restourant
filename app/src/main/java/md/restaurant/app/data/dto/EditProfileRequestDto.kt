package md.restaurant.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class EditProfileRequestDto(
    @SerializedName("_id") val _id: String?,
    val userId: UserRef?,  // ← теперь объект, а не строка
    val oldData: UserDataDto,
    val newData: UserDataDto,
    val status: String,
    val requestedAt: String,
    val processedAt: String? = null
)

data class UserRef(
    val _id: String,
    val name: String,
    val email: String
)

data class UserDataDto(
    val name: String,
    val email: String,
    val phone: String? = null,
    val avatar: String? = null
)