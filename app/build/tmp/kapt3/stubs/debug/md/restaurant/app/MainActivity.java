package md.restaurant.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import dagger.hilt.android.AndroidEntryPoint;
import md.restaurant.app.databinding.ActivityMainBinding;
import md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel;
import md.restaurant.app.utils.LanguageManager;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lmd/restaurant/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "badgeViewModel", "Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "binding", "Lmd/restaurant/app/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "recreateWithLanguage", "refreshNotificationBadge", "setupNotificationBadgeObserver", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private md.restaurant.app.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel badgeViewModel = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupNotificationBadgeObserver() {
    }
    
    public final void refreshNotificationBadge() {
    }
    
    public final void recreateWithLanguage() {
    }
}