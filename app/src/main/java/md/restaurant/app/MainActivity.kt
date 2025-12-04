package md.restaurant.app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import md.restaurant.app.databinding.ActivityMainBinding
import md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel
import md.restaurant.app.utils.LanguageManager

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val badgeViewModel = NotificationBadgeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        LanguageManager.attach(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        setupNotificationBadgeObserver()

        badgeViewModel.checkUnreadNotifications()
    }

    private fun setupNotificationBadgeObserver() {
        badgeViewModel.hasUnread.observe(this) { hasUnread ->
            val profileItem = binding.bottomNavigation.menu.findItem(R.id.profileFragment)
            profileItem.setIcon(
                if (hasUnread) R.drawable.nav_profile_with_badge
                else R.drawable.ic_person
            )
        }
    }

    // Вызывается из NotificationListFragment после прочтения
    fun refreshNotificationBadge() {
        badgeViewModel.checkUnreadNotifications()
    }

    fun recreateWithLanguage() {
        recreate()
    }
}