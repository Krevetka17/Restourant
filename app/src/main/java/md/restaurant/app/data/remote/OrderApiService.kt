package md.restaurant.app.data.remote.order

import md.restaurant.app.data.remote.dto.AvailableTablesResponse
import md.restaurant.app.data.remote.dto.CreateOrderRequest
import md.restaurant.app.data.remote.dto.OrderResponse
import md.restaurant.app.presentation.ui.profile.orders.Order
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface OrderApiService {
    @POST("orders")
    suspend fun createOrder(@Body request: CreateOrderRequest): OrderResponse

    @GET("tables/available")
    suspend fun getAvailableTables(
        @Query("date") date: String,
        @Query("start") start: String,
        @Query("duration") duration: Int = 120
    ): AvailableTablesResponse

    @GET("tables/available-interval")
    suspend fun getAvailableTablesInterval(
        @Query("date") date: String,
        @Query("start") start: String,
        @Query("end") end: String
    ): AvailableTablesResponse

    @GET("orders/{userId}")
    suspend fun getUserOrders(@Path("userId") userId: String): List<Order>
}