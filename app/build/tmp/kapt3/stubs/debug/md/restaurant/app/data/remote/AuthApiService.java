package md.restaurant.app.data.remote;

import md.restaurant.app.data.remote.dto.AuthResponse;
import md.restaurant.app.data.remote.dto.AuthRequest;
import md.restaurant.app.data.remote.dto.EditProfileRequestBody;
import md.restaurant.app.data.remote.dto.EditProfileRequestDto;
import md.restaurant.app.data.remote.dto.NotificationDto;
import md.restaurant.app.data.remote.dto.PaymentMethodsResponse;
import md.restaurant.app.data.remote.dto.RegisterRequest;
import md.restaurant.app.data.remote.dto.UserDto;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\b\b\u0001\u0010!\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\"\u001a\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020#H\u00a7@\u00a2\u0006\u0002\u0010$J.\u0010%\u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\u00062\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00a2\u0006\u0002\u0010&\u00a8\u0006\'"}, d2 = {"Lmd/restaurant/app/data/remote/AuthApiService;", "", "addPaymentMethod", "Lmd/restaurant/app/data/remote/dto/PaymentMethodsResponse;", "body", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmSetup", "createEditRequest", "", "Lmd/restaurant/app/data/remote/dto/EditProfileRequestBody;", "(Lmd/restaurant/app/data/remote/dto/EditProfileRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSetupIntent", "LSetupIntentResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePaymentMethod", "cardId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdminRequests", "", "Lmd/restaurant/app/data/remote/dto/EditProfileRequestDto;", "getCurrentUser", "Lmd/restaurant/app/data/remote/dto/UserDto;", "getNotifications", "Lmd/restaurant/app/data/remote/dto/NotificationDto;", "login", "Lmd/restaurant/app/data/remote/dto/AuthResponse;", "request", "Lmd/restaurant/app/data/remote/dto/AuthRequest;", "(Lmd/restaurant/app/data/remote/dto/AuthRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsRead", "Lretrofit2/Response;", "id", "register", "Lmd/restaurant/app/data/remote/dto/RegisterRequest;", "(Lmd/restaurant/app/data/remote/dto/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRequest", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
    
    @retrofit2.http.POST(value = "profile/payment-methods")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addPaymentMethod(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.PaymentMethodsResponse> $completion);
    
    @retrofit2.http.DELETE(value = "profile/payment-methods/{cardId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletePaymentMethod(@retrofit2.http.Path(value = "cardId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cardId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.PaymentMethodsResponse> $completion);
    
    @retrofit2.http.POST(value = "setup-intent")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createSetupIntent(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super SetupIntentResponse> $completion);
    
    @retrofit2.http.POST(value = "confirm-setup")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object confirmSetup(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super md.restaurant.app.data.remote.dto.PaymentMethodsResponse> $completion);
}