package md.restaurant.app.data.remote

import android.app.Application
import md.restaurant.app.RestaurantApp
import md.restaurant.app.utils.AuthManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthApiClient {
    private const val BASE_URL = "http://10.0.2.2:5002/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Интерцептор с правильным доступом к контексту
    private val authInterceptor = okhttp3.Interceptor { chain ->
        val original = chain.request()

        val token = AuthManager.getToken(RestaurantApp.instance)

        println("AuthApiClient → Токен: $token")

        val requestBuilder = original.newBuilder()
        if (!token.isNullOrBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        } else {
            println("ВНИМАНИЕ: Токен null или пустой!")
        }
        chain.proceed(requestBuilder.build())
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(authInterceptor)
        .build()

    val api: AuthApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthApiService::class.java)
}