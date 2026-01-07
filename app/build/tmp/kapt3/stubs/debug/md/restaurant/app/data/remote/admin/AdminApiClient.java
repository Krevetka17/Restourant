package md.restaurant.app.data.remote.admin;

import md.restaurant.app.utils.AuthManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lmd/restaurant/app/data/remote/admin/AdminApiClient;", "", "()V", "BASE_URL", "", "api", "Lmd/restaurant/app/data/remote/admin/AdminApiService;", "getApi", "()Lmd/restaurant/app/data/remote/admin/AdminApiService;", "client", "Lokhttp3/OkHttpClient;", "logging", "Lokhttp3/logging/HttpLoggingInterceptor;", "app_debug"})
public final class AdminApiClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "http://10.0.2.2:5004/";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.logging.HttpLoggingInterceptor logging = null;
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private static final md.restaurant.app.data.remote.admin.AdminApiService api = null;
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.data.remote.admin.AdminApiClient INSTANCE = null;
    
    private AdminApiClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.admin.AdminApiService getApi() {
        return null;
    }
}