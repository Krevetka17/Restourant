package md.restaurant.app.data.remote.dto

data class EditProfileRequestBody(
    val userId: String,
    val oldData: Map<String, String?>,
    val newData: Map<String, String?>
)