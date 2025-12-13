package md.restaurant.app.data.remote

import md.restaurant.app.data.remote.dto.AvatarResponseDto
import md.restaurant.app.data.remote.dto.SupportMessageDto
import md.restaurant.app.data.remote.dto.TicketInfoDto
import md.restaurant.app.data.remote.dto.TicketSummaryDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SupportApiService {

    @POST("messages")
    suspend fun sendMessage(@Body request: Map<String, String?>): Map<String, Any>

    @GET("tickets")
    suspend fun getUserTickets(@Query("userId") userId: String): List<TicketSummaryDto>

    @GET("messages")
    suspend fun getMessagesByTicket(@Query("ticketId") ticketId: String): List<SupportMessageDto>
    @GET("tickets/all")
    suspend fun getAllTickets(): List<TicketSummaryDto>

    @POST("messages/admin")
    suspend fun sendAdminMessage(@Body request: Map<String, String>)
    @GET("ticket/info")
    suspend fun getTicketInfo(@Query("ticketId") ticketId: String): TicketInfoDto

    @GET("user/avatar")
    suspend fun getUserAvatar(@Query("userId") userId: String): AvatarResponseDto
}