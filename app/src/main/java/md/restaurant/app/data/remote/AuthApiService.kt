// Путь: app/src/main/java/md/restaurant/app/data/remote/AuthApiService.kt
package md.restaurant.app.data.remote

import md.restaurant.app.data.remote.dto.AuthResponse
import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.data.remote.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("login")
    suspend fun login(@Body request: AuthRequest): AuthResponse

    @POST("register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
}