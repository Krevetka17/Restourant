package md.restaurant.app.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import md.restaurant.app.domain.model.CartItem;
import md.restaurant.app.data.remote.dto.MenuItemDto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0004J\u001e\u0010\u0019\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001e\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lmd/restaurant/app/utils/CartManager;", "", "()V", "KEY_CART", "", "PREF_NAME", "gson", "Lcom/google/gson/Gson;", "addItem", "", "context", "Landroid/content/Context;", "menuItem", "Lmd/restaurant/app/data/remote/dto/MenuItemDto;", "clearCart", "getCart", "", "Lmd/restaurant/app/domain/model/CartItem;", "getTotal", "", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "removeItem", "itemId", "saveCart", "cart", "updateQuantity", "quantity", "", "app_release"})
public final class CartManager {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "cart_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_CART = "cart_items";
    @org.jetbrains.annotations.NotNull()
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.utils.CartManager INSTANCE = null;
    
    private CartManager() {
        super();
    }
    
    private final android.content.SharedPreferences prefs(android.content.Context context) {
        return null;
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.MenuItemDto menuItem) {
    }
    
    public final void removeItem(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String itemId) {
    }
    
    public final void updateQuantity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String itemId, int quantity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<md.restaurant.app.domain.model.CartItem> getCart(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final double getTotal(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return 0.0;
    }
    
    public final void clearCart(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void saveCart(android.content.Context context, java.util.List<md.restaurant.app.domain.model.CartItem> cart) {
    }
}