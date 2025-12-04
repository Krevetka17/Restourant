package md.restaurant.app.data.remote;

import md.restaurant.app.data.remote.dto.AuthResponse;
import md.restaurant.app.data.remote.dto.AuthRequest;
import md.restaurant.app.data.remote.dto.EditProfileRequestBody;
import md.restaurant.app.data.remote.dto.EditProfileRequestDto;
import md.restaurant.app.data.remote.dto.NotificationDto;
import md.restaurant.app.data.remote.dto.RegisterRequest;
import md.restaurant.app.data.remote.dto.UserDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001bJ.\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lmd/restaurant/app/data/remote/AuthApiService;", "", "createEditRequest", "", "body", "Lmd/restaurant/app/data/remote/dto/EditProfileRequestBody;", "(Lmd/restaurant/app/data/remote/dto/EditProfileRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdminRequests", "", "Lmd/restaurant/app/data/remote/dto/EditProfileRequestDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Lmd/restaurant/app/data/remote/dto/UserDto;", "getNotifications", "Lmd/restaurant/app/data/remote/dto/NotificationDto;", "login", "Lmd/restaurant/app/data/remote/dto/AuthResponse;", "request", "Lmd/restaurant/app/data/remote/dto/AuthRequest;", "(Lmd/restaurant/app/data/remote/dto/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsRead", "Lretrofit2/Response;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lmd/restaurant/app/data/remote/dto/RegisterRequest;", "(Lmd/restaurant/app/data/remote/dto/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRequest", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface AuthApiService {
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.AuthRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
    
    @retrofit2.http.GET(value = "me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.UserDto> $completion);
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.AuthResponse> $completion);
    
    @retrofit2.http.POST(value = "profile/edit-request")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createEditRequest(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.EditProfileRequestBody body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.GET(value = "admin/edit-requests")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAdminRequests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.EditProfileRequestDto>> $completion);
    
    @retrofit2.http.POST(value = "admin/edit-request/{id}/resolve")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resolveRequest(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.GET(value = "notifications")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNotifications(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<md.restaurant.app.data.remote.dto.NotificationDto>> $completion);
    
    @retrofit2.http.POST(value = "notifications/{id}/read")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsRead(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}