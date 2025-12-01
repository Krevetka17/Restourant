package md.restaurant.app.utils;

import android.content.Context;
import com.google.gson.Gson;
import md.restaurant.app.data.remote.dto.UserDto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lmd/restaurant/app/utils/AuthManager;", "", "()V", "KEY_TOKEN", "", "KEY_USER", "PREF_NAME", "getToken", "context", "Landroid/content/Context;", "getUser", "Lmd/restaurant/app/data/remote/dto/UserDto;", "isLoggedIn", "", "logout", "", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "saveAuth", "token", "user", "app_debug"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "auth_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOKEN = "jwt_token";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER = "user_json";
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.utils.AuthManager INSTANCE = null;
    
    private AuthManager() {
        super();
    }
    
    private final android.content.SharedPreferences prefs(android.content.Context context) {
        return null;
    }
    
    public final void saveAuth(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDto user) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final md.restaurant.app.data.remote.dto.UserDto getUser(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final boolean isLoggedIn(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final void logout(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}