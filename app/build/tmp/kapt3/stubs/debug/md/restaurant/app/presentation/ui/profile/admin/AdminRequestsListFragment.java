package md.restaurant.app.presentation.ui.profile.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlinx.coroutines.Dispatchers;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.AuthApiService;
import md.restaurant.app.databinding.FragmentAdminRequestsBinding;
import md.restaurant.app.presentation.ui.profile.ProfileFragment;
import md.restaurant.app.presentation.ui.profile.main.MainProfileFragment;
import md.restaurant.app.utils.AuthManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/admin/AdminRequestsListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lmd/restaurant/app/databinding/FragmentAdminRequestsBinding;", "adapter", "Lmd/restaurant/app/presentation/ui/profile/admin/AdminRequestsAdapter;", "binding", "getBinding", "()Lmd/restaurant/app/databinding/FragmentAdminRequestsBinding;", "loadRequests", "", "onCreateView", "Landroid/view/View;", "inf", "Landroid/view/LayoutInflater;", "cg", "Landroid/view/ViewGroup;", "s", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "savedInstanceState", "reloadCurrentUser", "resolveRequest", "requestId", "", "action", "app_debug"})
public final class AdminRequestsListFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private md.restaurant.app.databinding.FragmentAdminRequestsBinding _binding;
    private md.restaurant.app.presentation.ui.profile.admin.AdminRequestsAdapter adapter;
    
    public AdminRequestsListFragment() {
        super();
    }
    
    private final md.restaurant.app.databinding.FragmentAdminRequestsBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inf, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup cg, @org.jetbrains.annotations.Nullable()
    android.os.Bundle s) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadRequests() {
    }
    
    private final void resolveRequest(java.lang.String requestId, java.lang.String action) {
    }
    
    private final void reloadCurrentUser() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}