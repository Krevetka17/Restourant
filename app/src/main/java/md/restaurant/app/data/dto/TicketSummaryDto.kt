package md.restaurant.app.data.remote.dto

import java.util.Date

data class TicketSummaryDto(
    val ticketId: String,
    val lastMessage: String,
    val lastTimestamp: Date
)