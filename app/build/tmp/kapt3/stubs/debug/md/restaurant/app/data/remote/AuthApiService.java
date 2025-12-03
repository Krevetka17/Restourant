package md.restaurant.app.data.remote;

import md.restaurant.app.data.remote.dto.AuthResponse;
import md.restaurant.app.data.remote.dto.AuthRequest;
import md.restaurant.app.data.remote.dto.RegisterRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lmd/restaurant/app/data/remote/AuthApiService;", "", "login", "Lmd/restaurant/app/data/remote/dto/AuthResponse;", "request", "Lmd/restaurant/app/data/remote/dto/AuthRequest;", "(Lmd/restaurant/app/data/remote/dto/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lmd/restaurant/app/data/remote/dto/RegisterRequest;", "(Lmd/restaurant/app/data/remote/dto/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AuthApiService {
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.AuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
}