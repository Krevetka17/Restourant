package md.restaurant.app.data.remote.admin

import md.restaurant.app.data.remote.dto.AdminOrder
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AdminApiService {
    @GET("admin/orders/pending")
    suspend fun getPendingOrders(): List<AdminOrder>

    @POST("admin/orders/{id}/confirm")
    suspend fun confirmOrder(@Path("id") id: String): Response<Unit>

    @POST("admin/orders/{id}/reject")
    suspend fun rejectOrder(@Path("id") id: String, @Body body: Map<String, String>): Response<Unit>
}