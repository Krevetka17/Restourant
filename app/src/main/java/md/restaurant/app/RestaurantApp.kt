package md.restaurant.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import md.restaurant.app.utils.LanguageManager

@HiltAndroidApp
class RestaurantApp : Application() {

    override fun onCreate() {
        super.onCreate()
        LanguageManager.attach(this)
    }
}