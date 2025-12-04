package md.restaurant.app.presentation.ui.profile.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import md.restaurant.app.data.remote.AuthApiClient

class NotificationBadgeViewModel : ViewModel() {

    private val _hasUnread = MutableLiveData<Boolean>(false)
    val hasUnread: LiveData<Boolean> = _hasUnread

    init {
        checkUnreadNotifications() // сразу при создании
    }

    fun checkUnreadNotifications() {
        viewModelScope.launch {
            try {
                val notifications = AuthApiClient.api.getNotifications()
                val hasUnreadCount = notifications.any { !it.isRead }
                _hasUnread.postValue(hasUnreadCount)
            } catch (e: Exception) {
                _hasUnread.postValue(false)
            }
        }
    }
}