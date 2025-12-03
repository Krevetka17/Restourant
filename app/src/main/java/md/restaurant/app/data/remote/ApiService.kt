package md.restaurant.app.data.remote

import md.restaurant.app.data.remote.dto.AuthRequest
import md.restaurant.app.data.remote.dto.AuthResponse
import md.restaurant.app.data.remote.dto.MenuItemDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("menu")
    suspend fun getMenu(): List<MenuItemDto>
}