package md.restaurant.app.presentation.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.dto.MenuItemDto;
import md.restaurant.app.databinding.ItemMenuHorizontalBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lmd/restaurant/app/presentation/ui/home/CategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmd/restaurant/app/presentation/ui/home/CategoryAdapter$VH;", "items", "", "Lmd/restaurant/app/data/remote/dto/MenuItemDto;", "onClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
public final class CategoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<md.restaurant.app.presentation.ui.home.CategoryAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> items = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<md.restaurant.app.data.remote.dto.MenuItemDto, kotlin.Unit> onClick = null;
    
    public CategoryAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<md.restaurant.app.data.remote.dto.MenuItemDto> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super md.restaurant.app.data.remote.dto.MenuItemDto, kotlin.Unit> onClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public md.restaurant.app.presentation.ui.home.CategoryAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.home.CategoryAdapter.VH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lmd/restaurant/app/presentation/ui/home/CategoryAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmd/restaurant/app/databinding/ItemMenuHorizontalBinding;", "(Lmd/restaurant/app/presentation/ui/home/CategoryAdapter;Lmd/restaurant/app/databinding/ItemMenuHorizontalBinding;)V", "getBinding", "()Lmd/restaurant/app/databinding/ItemMenuHorizontalBinding;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final md.restaurant.app.databinding.ItemMenuHorizontalBinding binding = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.databinding.ItemMenuHorizontalBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final md.restaurant.app.databinding.ItemMenuHorizontalBinding getBinding() {
            return null;
        }
    }
}