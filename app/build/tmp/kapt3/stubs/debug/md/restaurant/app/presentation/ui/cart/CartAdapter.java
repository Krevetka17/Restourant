package md.restaurant.app.presentation.ui.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import md.restaurant.app.databinding.ItemCartBinding;
import md.restaurant.app.domain.model.CartItem;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aBA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0014\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lmd/restaurant/app/presentation/ui/cart/CartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmd/restaurant/app/presentation/ui/cart/CartAdapter$ViewHolder;", "items", "", "Lmd/restaurant/app/domain/model/CartItem;", "onQuantityChange", "Lkotlin/Function2;", "", "", "", "onRemove", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "updateItems", "newItems", "", "ViewHolder", "app_debug"})
public final class CartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<md.restaurant.app.presentation.ui.cart.CartAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<md.restaurant.app.domain.model.CartItem> items;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> onQuantityChange = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onRemove = null;
    
    public CartAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<md.restaurant.app.domain.model.CartItem> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onQuantityChange, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onRemove) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public md.restaurant.app.presentation.ui.cart.CartAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.cart.CartAdapter.ViewHolder holder, int position) {
    }
    
    private final void removeItem(int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateItems(@org.jetbrains.annotations.NotNull()
    java.util.List<md.restaurant.app.domain.model.CartItem> newItems) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lmd/restaurant/app/presentation/ui/cart/CartAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmd/restaurant/app/databinding/ItemCartBinding;", "(Lmd/restaurant/app/databinding/ItemCartBinding;)V", "getBinding", "()Lmd/restaurant/app/databinding/ItemCartBinding;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final md.restaurant.app.databinding.ItemCartBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.databinding.ItemCartBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final md.restaurant.app.databinding.ItemCartBinding getBinding() {
            return null;
        }
    }
}