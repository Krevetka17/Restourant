package md.restaurant.app.presentation.ui.profile.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import md.restaurant.app.R;
import md.restaurant.app.databinding.FragmentMyOrdersBinding;
import md.restaurant.app.data.remote.order.OrderApiClient;
import md.restaurant.app.utils.AuthManager;
import java.text.SimpleDateFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lmd/restaurant/app/presentation/ui/profile/orders/OrderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "sdfDate", "Ljava/text/SimpleDateFormat;", "tvDate", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "tvOrderId", "tvReason", "tvStatus", "tvTable", "tvTime", "tvTotal", "bind", "", "order", "Lmd/restaurant/app/presentation/ui/profile/orders/Order;", "subtract30Minutes", "", "time", "app_debug"})
public final class OrderViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private final android.widget.TextView tvOrderId = null;
    private final android.widget.TextView tvDate = null;
    private final android.widget.TextView tvTime = null;
    private final android.widget.TextView tvTable = null;
    private final android.widget.TextView tvTotal = null;
    private final android.widget.TextView tvStatus = null;
    private final android.widget.TextView tvReason = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat sdfDate = null;
    
    public OrderViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super(null);
    }
    
    private final java.lang.String subtract30Minutes(java.lang.String time) {
        return null;
    }
    
    public final void bind(@org.jetbrains.annotations.NotNull()
    md.restaurant.app.presentation.ui.profile.orders.Order order) {
    }
}