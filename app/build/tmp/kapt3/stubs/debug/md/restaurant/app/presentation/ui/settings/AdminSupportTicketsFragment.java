package md.restaurant.app.presentation.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlinx.coroutines.Dispatchers;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.SupportApiClient;
import md.restaurant.app.data.remote.dto.TicketSummaryDto;
import java.text.SimpleDateFormat;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment$AdminTicketsAdapter;", "rvTickets", "Landroidx/recyclerview/widget/RecyclerView;", "loadTickets", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "AdminTicketsAdapter", "app_debug"})
public final class AdminSupportTicketsFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView rvTickets;
    @org.jetbrains.annotations.NotNull()
    private final md.restaurant.app.presentation.ui.settings.AdminSupportTicketsFragment.AdminTicketsAdapter adapter = null;
    
    public AdminSupportTicketsFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void loadTickets() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0014\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment$AdminTicketsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment$AdminTicketsAdapter$ViewHolder;", "Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment;", "(Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment;)V", "tickets", "", "Lmd/restaurant/app/data/remote/dto/TicketSummaryDto;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "newTickets", "", "ViewHolder", "app_debug"})
    public final class AdminTicketsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<md.restaurant.app.presentation.ui.settings.AdminSupportTicketsFragment.AdminTicketsAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<md.restaurant.app.data.remote.dto.TicketSummaryDto> tickets = null;
        
        public AdminTicketsAdapter() {
            super();
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        java.util.List<md.restaurant.app.data.remote.dto.TicketSummaryDto> newTickets) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public md.restaurant.app.presentation.ui.settings.AdminSupportTicketsFragment.AdminTicketsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        md.restaurant.app.presentation.ui.settings.AdminSupportTicketsFragment.AdminTicketsAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment$AdminTicketsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lmd/restaurant/app/presentation/ui/settings/AdminSupportTicketsFragment$AdminTicketsAdapter;Landroid/view/View;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "tvDate", "Landroid/widget/TextView;", "tvPreview", "tvUserName", "bind", "", "ticket", "Lmd/restaurant/app/data/remote/dto/TicketSummaryDto;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvUserName = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvPreview = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView tvDate = null;
            @org.jetbrains.annotations.NotNull()
            private final java.text.SimpleDateFormat dateFormat = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            android.view.View itemView) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            md.restaurant.app.data.remote.dto.TicketSummaryDto ticket) {
            }
        }
    }
}