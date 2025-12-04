package md.restaurant.app.presentation.ui.profile.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import md.restaurant.app.data.remote.AuthApiClient;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_hasUnread", "Landroidx/lifecycle/MutableLiveData;", "", "hasUnread", "Landroidx/lifecycle/LiveData;", "getHasUnread", "()Landroidx/lifecycle/LiveData;", "checkUnreadNotifications", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NotificationBadgeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _hasUnread = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> hasUnread = null;
    
    @javax.inject.Inject()
    public NotificationBadgeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getHasUnread() {
        return null;
    }
    
    public final void checkUnreadNotifications() {
    }
}