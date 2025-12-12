package md.restaurant.app.presentation.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import md.restaurant.app.R;
import md.restaurant.app.data.remote.SupportApiClient;
import md.restaurant.app.utils.AuthManager;
import md.restaurant.app.RestaurantApp;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import android.util.Base64;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lmd/restaurant/app/presentation/ui/settings/SupportSpecificChatFragment;", "Landroidx/fragment/app/Fragment;", "()V", "chatContainer", "Landroid/widget/LinearLayout;", "ticketId", "", "addSupportMessage", "", "text", "addUserMessage", "loadMessages", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "sendMessageToServer", "message", "Companion", "app_debug"})
public final class SupportSpecificChatFragment extends androidx.fragment.app.Fragment {
    private android.widget.LinearLayout chatContainer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String ticketId;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ARG_TICKET_ID = "ticket_id";
    @org.jetbrains.annotations.NotNull()
    public static final md.restaurant.app.presentation.ui.settings.SupportSpecificChatFragment.Companion Companion = null;
    
    public SupportSpecificChatFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void loadMessages() {
    }
    
    private final void addSupportMessage(java.lang.String text) {
    }
    
    private final void addUserMessage(java.lang.String text) {
    }
    
    private final void sendMessageToServer(java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lmd/restaurant/app/presentation/ui/settings/SupportSpecificChatFragment$Companion;", "", "()V", "ARG_TICKET_ID", "", "newInstance", "Lmd/restaurant/app/presentation/ui/settings/SupportSpecificChatFragment;", "ticketId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final md.restaurant.app.presentation.ui.settings.SupportSpecificChatFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String ticketId) {
            return null;
        }
    }
}