package md.restaurant.app.data.remote;

import md.restaurant.app.data.remote.dto.SupportMessageDto;
import md.restaurant.app.data.remote.dto.TicketSummaryDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J2\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\f2\u0016\b\u0001\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\fH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lmd/restaurant/app/data/remote/SupportApiService;", "", "getMessagesByTicket", "", "Lmd/restaurant/app/data/remote/dto/SupportMessageDto;", "ticketId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserTickets", "Lmd/restaurant/app/data/remote/dto/TicketSummaryDto;", "userId", "sendMessage", "", "request", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SupportApiService {
    
    @retrofit2.http.POST(value = "messages")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sendMessage(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> $completion);
    
    @retrofit2.http.GET(value = "tickets")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserTickets(@retrofit2.http.Query(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.TicketSummaryDto>> $completion);
    
    @retrofit2.http.GET(value = "messages")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMessagesByTicket(@retrofit2.http.Query(value = "ticketId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String ticketId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.SupportMessageDto>> $completion);
}