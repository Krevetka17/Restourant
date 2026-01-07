package md.restaurant.app.data.remote.admin;

import md.restaurant.app.data.remote.dto.AdminOrder;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00a2\u0006\u0002\u0010\tJ.\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lmd/restaurant/app/data/remote/admin/AdminApiService;", "", "confirmOrder", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingOrders", "", "Lmd/restaurant/app/data/remote/dto/AdminOrder;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rejectOrder", "body", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AdminApiService {
    
    @retrofit2.http.GET(value = "admin/orders/pending")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPendingOrders(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.AdminOrder>> $completion);
    
    @retrofit2.http.POST(value = "admin/orders/{id}/confirm")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object confirmOrder(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<java.lang.Object> $completion);
    
    @retrofit2.http.POST(value = "admin/orders/{id}/reject")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object rejectOrder(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<java.lang.Object> $completion);
}