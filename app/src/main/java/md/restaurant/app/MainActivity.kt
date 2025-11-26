package md.restaurant.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import md.restaurant.app.databinding.ActivityMainBinding
import md.restaurant.app.utils.LanguageManager

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // 1. ПРИМЕНЯЕМ ТЕМУ ДО super.onCreate()
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val themeRes = prefs.getInt("screen_style", R.style.Theme_Restaurant)
        setTheme(themeRes)

        // 2. Применяем язык
        LanguageManager.attach(this)

        // 3. Только теперь запускаем Activity
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun recreateWithLanguage() {
        recreate()
    }
}
