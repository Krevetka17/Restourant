// Путь: app/src/main/java/md/restaurant/app/data/remote/AuthApiService.kt
package md.restaurant.app.data.remote

import md.restaurant.app.data.remote.dto.AuthResponse
import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.data.remote.dto.EditProfileRequestBody
import md.restaurant.app.data.remote.dto.EditProfileRequestDto
import md.restaurant.app.data.remote.dto.NotificationDto
import md.restaurant.app.data.remote.dto.RegisterRequest
import md.restaurant.app.data.remote.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApiService {
    @POST("login")
    suspend fun login(@Body request: AuthRequest): AuthResponse
    @GET("me")
    suspend fun getCurrentUser(): UserDto
    @POST("register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
    @POST("profile/edit-request")
    suspend fun createEditRequest(@Body body: EditProfileRequestBody)
    @GET("admin/edit-requests")
    suspend fun getAdminRequests(): List<EditProfileRequestDto>
    @POST("admin/edit-request/{id}/resolve")
    suspend fun resolveRequest(@Path("id") id: String, @Body body: Map<String, String>)
    @GET("notifications")
    suspend fun getNotifications(): List<NotificationDto>
    @POST("notifications/{id}/read")
    suspend fun markAsRead(@Path("id") id: String): retrofit2.Response<Unit>

}