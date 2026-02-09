package md.restaurant.app.presentation.ui.profile.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.dto.PaymentMethodDto;
import md.restaurant.app.databinding.ItemPaymentCardBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B;\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/payment/PaymentMethodsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmd/restaurant/app/data/remote/dto/PaymentMethodDto;", "Lmd/restaurant/app/presentation/ui/profile/payment/PaymentMethodsAdapter$CardVH;", "onSelect", "Lkotlin/Function1;", "", "", "onDelete", "selectedId", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "onBindViewHolder", "vh", "pos", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateSelected", "id", "CardVH", "Diff", "app_debug"})
public final class PaymentMethodsAdapter extends androidx.recyclerview.widget.ListAdapter<md.restaurant.app.data.remote.dto.PaymentMethodDto, md.restaurant.app.presentation.ui.profile.payment.PaymentMethodsAdapter.CardVH> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onSelect = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedId;
    
    public PaymentMethodsAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSelect, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDelete, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedId) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public md.restaurant.app.presentation.ui.profile.payment.PaymentMethodsAdapter.CardVH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.profile.payment.PaymentMethodsAdapter.CardVH vh, int pos) {
    }
    
    public final void updateSelected(@org.jetbrains.annotations.Nullable()
    java.lang.String id) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/payment/PaymentMethodsAdapter$CardVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lmd/restaurant/app/databinding/ItemPaymentCardBinding;", "(Lmd/restaurant/app/databinding/ItemPaymentCardBinding;)V", "getB", "()Lmd/restaurant/app/databinding/ItemPaymentCardBinding;", "app_debug"})
    public static final class CardVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final md.restaurant.app.databinding.ItemPaymentCardBinding b = null;
        
        public CardVH(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.databinding.ItemPaymentCardBinding b) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final md.restaurant.app.databinding.ItemPaymentCardBinding getB() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/payment/PaymentMethodsAdapter$Diff;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lmd/restaurant/app/data/remote/dto/PaymentMethodDto;", "()V", "areContentsTheSame", "", "a", "b", "areItemsTheSame", "app_debug"})
    public static final class Diff extends androidx.recyclerview.widget.DiffUtil.ItemCallback<md.restaurant.app.data.remote.dto.PaymentMethodDto> {
        
        public Diff() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.data.remote.dto.PaymentMethodDto a, @org.jetbrains.annotations.NotNull()
        md.restaurant.app.data.remote.dto.PaymentMethodDto b) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.data.remote.dto.PaymentMethodDto a, @org.jetbrains.annotations.NotNull()
        md.restaurant.app.data.remote.dto.PaymentMethodDto b) {
            return false;
        }
    }
}