package md.restaurant.app.presentation.ui.profile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlinx.coroutines.Dispatchers;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.AuthApiService;
import md.restaurant.app.databinding.FragmentProfileBinding;
import md.restaurant.app.presentation.ui.profile.admin.AdminPanelFragment;
import md.restaurant.app.presentation.ui.profile.edit.EditProfileFragment;
import md.restaurant.app.presentation.ui.profile.login.LoginFragment;
import md.restaurant.app.presentation.ui.profile.main.MainProfileFragment;
import md.restaurant.app.presentation.ui.profile.notifications.NotificationListFragment;
import md.restaurant.app.presentation.ui.profile.notifications.NotificationsFragment;
import md.restaurant.app.presentation.ui.profile.orders.MyOrdersFragment;
import md.restaurant.app.presentation.ui.profile.register.RegisterFragment;
import md.restaurant.app.utils.AuthManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u001c\u001a\u00020\u0017J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0017J\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lmd/restaurant/app/databinding/FragmentProfileBinding;", "binding", "getBinding", "()Lmd/restaurant/app/databinding/FragmentProfileBinding;", "handler", "Landroid/os/Handler;", "refreshInterval", "", "refreshRunnable", "Ljava/lang/Runnable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onPause", "onResume", "onViewCreated", "view", "refreshNotifications", "refreshUserData", "showAdminPanel", "showEditProfile", "showLogin", "showMainProfile", "showMyOrders", "showNotifications", "showRegister", "app_debug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private md.restaurant.app.databinding.FragmentProfileBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private final long refreshInterval = 20000L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Runnable refreshRunnable = null;
    
    public ProfileFragment() {
        super();
    }
    
    private final md.restaurant.app.databinding.FragmentProfileBinding getBinding() {
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    private final void refreshUserData() {
    }
    
    public final void showLogin() {
    }
    
    public final void showRegister() {
    }
    
    public final void showMainProfile() {
    }
    
    public final void showEditProfile() {
    }
    
    public final void showAdminPanel() {
    }
    
    public final void showNotifications() {
    }
    
    public final void showMyOrders() {
    }
    
    public final void refreshNotifications() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}