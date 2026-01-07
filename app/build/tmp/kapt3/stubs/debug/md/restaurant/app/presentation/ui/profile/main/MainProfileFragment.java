package md.restaurant.app.presentation.ui.profile.main;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.AuthApiClient;
import md.restaurant.app.databinding.FragmentMainProfileBinding;
import md.restaurant.app.presentation.ui.profile.ProfileFragment;
import md.restaurant.app.utils.AuthManager;
import md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0006\u0010#\u001a\u00020\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006$"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/main/MainProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lmd/restaurant/app/databinding/FragmentMainProfileBinding;", "badgeViewModel", "Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "getBadgeViewModel", "()Lmd/restaurant/app/presentation/ui/profile/notifications/NotificationBadgeViewModel;", "badgeViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lmd/restaurant/app/databinding/FragmentMainProfileBinding;", "base64ToBitmap", "Landroid/graphics/Bitmap;", "base64", "", "observeNotificationBadge", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "refreshAllData", "setupButtons", "setupSwipeRefresh", "updateAdminButton", "updateUserInfo", "app_debug"})
public final class MainProfileFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private md.restaurant.app.databinding.FragmentMainProfileBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy badgeViewModel$delegate = null;
    
    public MainProfileFragment() {
        super();
    }
    
    private final md.restaurant.app.databinding.FragmentMainProfileBinding getBinding() {
        return null;
    }
    
    private final md.restaurant.app.presentation.ui.profile.notifications.NotificationBadgeViewModel getBadgeViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupSwipeRefresh() {
    }
    
    private final void setupButtons() {
    }
    
    private final void updateAdminButton() {
    }
    
    private final void observeNotificationBadge() {
    }
    
    private final void refreshAllData() {
    }
    
    public final void updateUserInfo() {
    }
    
    private final android.graphics.Bitmap base64ToBitmap(java.lang.String base64) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}