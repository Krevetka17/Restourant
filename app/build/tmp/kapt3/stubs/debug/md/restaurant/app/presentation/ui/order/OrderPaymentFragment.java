package md.restaurant.app.presentation.ui.order;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import md.restaurant.app.R;
import md.restaurant.app.databinding.FragmentOrderPaymentBinding;
import md.restaurant.app.utils.CartManager;
import md.restaurant.app.utils.AuthManager;
import md.restaurant.app.data.remote.AuthApiClient;
import md.restaurant.app.data.remote.dto.CartItemRequest;
import md.restaurant.app.data.remote.dto.CreateOrderRequest;
import md.restaurant.app.data.remote.order.OrderApiClient;
import md.restaurant.app.presentation.ui.cart.CartFragment;
import md.restaurant.app.presentation.ui.profile.payment.PaymentMethodsAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+H\u0082@\u00a2\u0006\u0002\u0010,J\u0018\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0016H\u0002J\u0006\u00103\u001a\u00020$J\u0012\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u000106H\u0016J$\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J*\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0016J\b\u0010C\u001a\u00020$H\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u0013H\u0016J\u001a\u0010F\u001a\u00020$2\u0006\u0010>\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020\u0016H\u0002J\b\u0010I\u001a\u00020$H\u0002J\b\u0010J\u001a\u00020$H\u0002J\u0016\u0010K\u001a\u00020$2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010M\u001a\u00020$H\u0002J\b\u0010N\u001a\u00020$H\u0002J\b\u0010O\u001a\u00020$H\u0002J\b\u0010P\u001a\u00020$H\u0002J\u0010\u0010Q\u001a\u00020$2\u0006\u0010R\u001a\u00020\tH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001fR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00160\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lmd/restaurant/app/presentation/ui/order/OrderPaymentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/wdullaer/materialdatetimepicker/date/DatePickerDialog$OnDateSetListener;", "()V", "_binding", "Lmd/restaurant/app/databinding/FragmentOrderPaymentBinding;", "availableTables", "", "", "binding", "getBinding", "()Lmd/restaurant/app/databinding/FragmentOrderPaymentBinding;", "cardsAdapter", "Lmd/restaurant/app/presentation/ui/profile/payment/PaymentMethodsAdapter;", "dayMonthFormat", "Ljava/text/SimpleDateFormat;", "dayOfWeekFormat", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "locationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "orderType", "paymentMethod", "selectedDate", "selectedDateDisplay", "selectedEndTime", "selectedOnlineCardId", "selectedStartTime", "selectedTable", "Ljava/lang/Integer;", "timeList", "add30Minutes", "time", "confirmOrder", "", "enableMyLocation", "formatDisplayDate", "cal", "Ljava/util/Calendar;", "getAddressFromLatLng", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "(Lcom/google/android/gms/maps/model/LatLng;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatLngFromAddress", "address", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAvailableTables", "startTime", "endTime", "loadCards", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDateSet", "view", "Lcom/wdullaer/materialdatetimepicker/date/DatePickerDialog;", "year", "monthOfYear", "dayOfMonth", "onDestroyView", "onMapReady", "map", "onViewCreated", "searchLocationOnMap", "query", "setupDatePicker", "setupPaymentToggle", "setupTablesRecycler", "tables", "setupTimeSpinners", "setupTypeToggle", "showMaterialDatePicker", "updateDateText", "updateEndTimeSpinner", "startPosition", "app_debug"})
public final class OrderPaymentFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback, com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {
    @org.jetbrains.annotations.Nullable()
    private md.restaurant.app.databinding.FragmentOrderPaymentBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String orderType = "delivery";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String paymentMethod = "cash";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedOnlineCardId;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.GoogleMap googleMap;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedStartTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedEndTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer selectedTable;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> availableTables;
    private java.util.List<java.lang.String> timeList;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedDateDisplay = "";
    private androidx.activity.result.ActivityResultLauncher<java.lang.String> locationPermissionLauncher;
    private md.restaurant.app.presentation.ui.profile.payment.PaymentMethodsAdapter cardsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dayOfWeekFormat = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dayMonthFormat = null;
    
    public OrderPaymentFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final md.restaurant.app.databinding.FragmentOrderPaymentBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    public final void loadCards() {
    }
    
    private final void setupPaymentToggle() {
    }
    
    private final java.lang.String formatDisplayDate(java.util.Calendar cal) {
        return null;
    }
    
    private final void updateDateText() {
    }
    
    private final void setupDatePicker() {
    }
    
    private final void showMaterialDatePicker() {
    }
    
    @java.lang.Override()
    public void onDateSet(@org.jetbrains.annotations.Nullable()
    com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
    }
    
    private final void setupTimeSpinners() {
    }
    
    private final void updateEndTimeSpinner(int startPosition) {
    }
    
    private final java.lang.String add30Minutes(java.lang.String time) {
        return null;
    }
    
    private final void loadAvailableTables(java.lang.String startTime, java.lang.String endTime) {
    }
    
    private final void setupTablesRecycler(java.util.List<java.lang.Integer> tables) {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap map) {
    }
    
    private final void enableMyLocation() {
    }
    
    private final java.lang.Object getAddressFromLatLng(com.google.android.gms.maps.model.LatLng latLng, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final void searchLocationOnMap(java.lang.String query) {
    }
    
    private final java.lang.Object getLatLngFromAddress(java.lang.String address, kotlin.coroutines.Continuation<? super com.google.android.gms.maps.model.LatLng> $completion) {
        return null;
    }
    
    private final void setupTypeToggle() {
    }
    
    private final void confirmOrder() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}