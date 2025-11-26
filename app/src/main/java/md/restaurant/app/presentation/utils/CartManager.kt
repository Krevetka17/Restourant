// utils/CartManager.kt
package md.restaurant.app.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import md.restaurant.app.domain.model.CartItem
import md.restaurant.app.data.remote.dto.MenuItemDto

object CartManager {
    private const val PREF_NAME = "cart_prefs"
    private const val KEY_CART = "cart_items"
    private val gson = Gson()

    private fun prefs(context: Context) = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun addItem(context: Context, menuItem: MenuItemDto) {
        val cart = getCart(context).toMutableList()
        val existing = cart.find { it.menuItem._id == menuItem._id }
        if (existing != null) {
            existing.quantity++
        } else {
            cart.add(CartItem(menuItem))
        }
        saveCart(context, cart)
    }

    fun removeItem(context: Context, itemId: String) {
        val cart = getCart(context).toMutableList()
        cart.removeAll { it.menuItem._id == itemId }
        saveCart(context, cart)
    }

    fun updateQuantity(context: Context, itemId: String, quantity: Int) {
        val cart = getCart(context).toMutableList()
        cart.find { it.menuItem._id == itemId }?.quantity = quantity.coerceAtLeast(1)
        saveCart(context, cart)
    }

    fun getCart(context: Context): List<CartItem> {
        val json = prefs(context).getString(KEY_CART, null) ?: return emptyList()
        val type = object : TypeToken<List<CartItem>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    fun getTotal(context: Context): Double =
        getCart(context).sumOf { it.menuItem.price * it.quantity }

    fun clearCart(context: Context) {
        prefs(context).edit().remove(KEY_CART).apply()
    }

    private fun saveCart(context: Context, cart: List<CartItem>) {
        val json = gson.toJson(cart)
        prefs(context).edit().putString(KEY_CART, json).apply()
    }
}