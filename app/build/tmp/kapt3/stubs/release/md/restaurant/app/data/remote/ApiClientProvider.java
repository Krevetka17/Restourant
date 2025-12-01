package md.restaurant.app.data.remote;

import android.content.Context;
import md.restaurant.app.utils.AuthManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lmd/restaurant/app/data/remote/ApiClientProvider;", "", "()V", "api", "Lmd/restaurant/app/data/remote/ApiService;", "getApi", "()Lmd/restaurant/app/data/remote/ApiService;", "instance", "Lmd/restaurant/app/data/remote/ApiClient;", "init", "", "context", "Landroid/content/Context;", "app_release"})
public final class ApiClientProvider {
    @org.jetbrains.annotations.Nullable()
    private static md.restaurant.app.data.remote.ApiClient instance;
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.data.remote.ApiClientProvider INSTANCE = null;
    
    private ApiClientProvider() {
        super();
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.data.remote.ApiService getApi() {
        return null;
    }
}