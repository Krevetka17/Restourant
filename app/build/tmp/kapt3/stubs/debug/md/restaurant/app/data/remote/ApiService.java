package md.restaurant.app.data.remote;

import md.restaurant.app.data.remote.dto.AuthRequest;
import md.restaurant.app.data.remote.dto.AuthResponse;
import md.restaurant.app.data.remote.dto.MenuItemDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\f"}, d2 = {"Lmd/restaurant/app/data/remote/ApiService;", "", "getMenu", "", "Lmd/restaurant/app/data/remote/dto/MenuItemDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lmd/restaurant/app/data/remote/dto/AuthResponse;", "request", "Lmd/restaurant/app/data/remote/dto/AuthRequest;", "(Lmd/restaurant/app/data/remote/dto/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "auth/register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.AuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
    
    @retrofit2.http.POST(value = "auth/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.AuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
    
    @retrofit2.http.GET(value = "menu")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMenu(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto>> $completion);
}