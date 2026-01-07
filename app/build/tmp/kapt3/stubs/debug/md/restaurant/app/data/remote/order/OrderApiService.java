package md.restaurant.app.data.remote.order;

import md.restaurant.app.data.remote.dto.AvailableTablesResponse;
import md.restaurant.app.data.remote.dto.CreateOrderRequest;
import md.restaurant.app.data.remote.dto.OrderResponse;
import md.restaurant.app.presentation.ui.profile.orders.Order;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0001\u0010\u0015\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lmd/restaurant/app/data/remote/order/OrderApiService;", "", "createOrder", "Lmd/restaurant/app/data/remote/dto/OrderResponse;", "request", "Lmd/restaurant/app/data/remote/dto/CreateOrderRequest;", "(Lmd/restaurant/app/data/remote/dto/CreateOrderRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvailableTables", "Lmd/restaurant/app/data/remote/dto/AvailableTablesResponse;", "date", "", "start", "duration", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvailableTablesInterval", "end", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserOrders", "", "Lmd/restaurant/app/presentation/ui/profile/orders/Order;", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface OrderApiService {
    
    @retrofit2.http.POST(value = "orders")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createOrder(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.CreateOrderRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.OrderResponse> $completion);
    
    @retrofit2.http.GET(value = "tables/available")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAvailableTables(@retrofit2.http.Query(value = "date")
    @org.jetbrains.annotations.NotNull()
    java.lang.String date, @retrofit2.http.Query(value = "start")
    @org.jetbrains.annotations.NotNull()
    java.lang.String start, @retrofit2.http.Query(value = "duration")
    int duration, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AvailableTablesResponse> $completion);
    
    @retrofit2.http.GET(value = "tables/available-interval")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAvailableTablesInterval(@retrofit2.http.Query(value = "date")
    @org.jetbrains.annotations.NotNull()
    java.lang.String date, @retrofit2.http.Query(value = "start")
    @org.jetbrains.annotations.NotNull()
    java.lang.String start, @retrofit2.http.Query(value = "end")
    @org.jetbrains.annotations.NotNull()
    java.lang.String end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AvailableTablesResponse> $completion);
    
    @retrofit2.http.GET(value = "orders/{userId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUserOrders(@retrofit2.http.Path(value = "userId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.presentation.ui.profile.orders.Order>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}