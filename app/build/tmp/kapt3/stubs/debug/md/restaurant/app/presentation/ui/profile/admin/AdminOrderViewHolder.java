package md.restaurant.app.presentation.ui.profile.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import md.restaurant.app.data.remote.admin.AdminApiClient;
import md.restaurant.app.data.remote.dto.AdminOrder;
import md.restaurant.app.databinding.ItemAdminOrderBinding;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/admin/AdminOrderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmd/restaurant/app/databinding/ItemAdminOrderBinding;", "(Lmd/restaurant/app/databinding/ItemAdminOrderBinding;)V", "sdfDate", "Ljava/text/SimpleDateFormat;", "bind", "", "order", "Lmd/restaurant/app/data/remote/dto/AdminOrder;", "adapter", "Lmd/restaurant/app/presentation/ui/profile/admin/AdminOrderAdapter;", "subtract30Minutes", "", "time", "app_debug"})
public final class AdminOrderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final md.restaurant.app.databinding.ItemAdminOrderBinding binding = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat sdfDate = null;
    
    public AdminOrderViewHolder(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.databinding.ItemAdminOrderBinding binding) {
        super(null);
    }
    
    private final java.lang.String subtract30Minutes(java.lang.String time) {
        return null;
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.data.remote.dto.AdminOrder order, @org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.profile.admin.AdminOrderAdapter adapter) {
    }
}