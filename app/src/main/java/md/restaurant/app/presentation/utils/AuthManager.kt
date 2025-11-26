package md.restaurant.app.utils

import android.content.Context
import com.google.gson.Gson
import md.restaurant.app.data.remote.dto.UserDto

object AuthManager {
    private const val PREF_NAME = "auth_prefs"
    private const val KEY_TOKEN = "jwt_token"
    private const val KEY_USER = "user_json"

    private fun prefs(context: Context) = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveAuth(context: Context, token: String, user: UserDto) {
        prefs(context).edit()
            .putString(KEY_TOKEN, token)
            .putString(KEY_USER, Gson().toJson(user))
            .apply()
    }

    fun getToken(context: Context? = null): String? =
        context?.let { prefs(it).getString(KEY_TOKEN, null) }

    fun getUser(context: Context): UserDto? {
        val json = prefs(context).getString(KEY_USER, null) ?: return null
        return Gson().fromJson(json, UserDto::class.java)
    }

    fun isLoggedIn(context: Context): Boolean = getToken(context) != null

    fun logout(context: Context) {
        prefs(context).edit().clear().apply()
    }
}