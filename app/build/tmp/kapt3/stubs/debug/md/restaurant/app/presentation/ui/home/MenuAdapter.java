package md.restaurant.app.presentation.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import md.restaurant.app.databinding.ItemMenuBinding;
import md.restaurant.app.data.remote.dto.MenuItemDto;
import md.restaurant.app.utils.CartManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import md.restaurant.app.R;
import android.graphics.Color;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.view.Gravity;
import android.widget.FrameLayout;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lmd/restaurant/app/presentation/ui/home/MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmd/restaurant/app/presentation/ui/home/MenuAdapter$VH;", "items", "", "Lmd/restaurant/app/data/remote/dto/MenuItemDto;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
public final class MenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<md.restaurant.app.presentation.ui.home.MenuAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> items = null;
    
    public MenuAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> items) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public md.restaurant.app.presentation.ui.home.MenuAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.home.MenuAdapter.VH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lmd/restaurant/app/presentation/ui/home/MenuAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmd/restaurant/app/databinding/ItemMenuBinding;", "(Lmd/restaurant/app/presentation/ui/home/MenuAdapter;Lmd/restaurant/app/databinding/ItemMenuBinding;)V", "getBinding", "()Lmd/restaurant/app/databinding/ItemMenuBinding;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final md.restaurant.app.databinding.ItemMenuBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.databinding.ItemMenuBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final md.restaurant.app.databinding.ItemMenuBinding getBinding() {
            return null;
        }
    }
}