package md.restaurant.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import dagger.hilt.android.AndroidEntryPoint;
import md.restaurant.app.databinding.ActivityMainBinding;
import md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel;
import md.restaurant.app.utils.LanguageManager;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lmd/restaurant/app/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "badgeViewModel", "Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "getBadgeViewModel", "()Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "badgeViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lmd/restaurant/app/databinding/ActivityMainBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "recreateWithLanguage", "refreshNotificationBadge", "setupNotificationBadgeObserver", "app_release"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private md.restaurant.app.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy badgeViewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel getBadgeViewModel() {
        return null;
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