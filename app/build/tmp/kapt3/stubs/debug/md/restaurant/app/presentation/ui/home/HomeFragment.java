package md.restaurant.app.presentation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlinx.coroutines.*;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.ApiClient;
import md.restaurant.app.data.remote.dto.MenuItemDto;
import md.restaurant.app.databinding.FragmentHomeBinding;
import md.restaurant.app.databinding.ItemCategorySectionBinding;
import md.restaurant.app.presentation.ui.dish.DishDetailFragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0011H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\'\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lmd/restaurant/app/presentation/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lmd/restaurant/app/databinding/FragmentHomeBinding;", "allItems", "", "Lmd/restaurant/app/data/remote/dto/MenuItemDto;", "binding", "getBinding", "()Lmd/restaurant/app/databinding/FragmentHomeBinding;", "categories", "", "", "menuByCategory", "", "buildUI", "", "groupByCategories", "menu", "hideDishDetail", "loadMenu", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "performSearch", "query", "scrollToCategory", "index", "", "showDishDetail", "item", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private md.restaurant.app.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> categories = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto>> menuByCategory = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> allItems;
    
    public HomeFragment() {
        super();
    }
    
    private final md.restaurant.app.databinding.FragmentHomeBinding getBinding() {
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
    
    private final void loadMenu() {
    }
    
    private final void groupByCategories(java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> menu) {
    }
    
    private final void buildUI() {
    }
    
    private final void scrollToCategory(int index) {
    }
    
    private final void performSearch(java.lang.String query) {
    }
    
    private final void showDishDetail(md.restaurant.app.data.remote.dto.MenuItemDto item) {
    }
    
    public final void hideDishDetail() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}