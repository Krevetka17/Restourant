package md.restaurant.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import md.restaurant.app.data.remote.dto.UserDto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lmd/restaurant/app/utils/AuthManager;", "", "()V", "KEY_IS_ADMIN", "", "KEY_TOKEN", "KEY_USER_EMAIL", "KEY_USER_ID", "KEY_USER_NAME", "PREF_NAME", "getPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "getToken", "getUser", "Lmd/restaurant/app/data/remote/dto/UserDto;", "isLoggedIn", "", "logout", "", "saveAuth", "token", "user", "app_release"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "auth_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TOKEN = "jwt_token";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_IS_ADMIN = "is_admin";
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.utils.AuthManager INSTANCE = null;
    
    private AuthManager() {
        super();
    }
    
    private final android.content.SharedPreferences getPrefs(android.content.Context context) {
        return null;
    }
    
    public final void saveAuth(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.UserDto user) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getToken(@org.jetbrains.annotations.NotNull()
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