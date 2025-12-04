package md.restaurant.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import md.restaurant.app.utils.LanguageManager

@HiltAndroidApp
class RestaurantApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        LanguageManager.attach(this)
    }

    companion object {
        lateinit var instance: RestaurantApp
            private set
    }
}