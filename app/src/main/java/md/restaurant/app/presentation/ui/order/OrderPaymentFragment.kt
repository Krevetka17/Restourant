package md.restaurant.app.presentation.ui.order

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentOrderPaymentBinding
import md.restaurant.app.utils.CartManager
import md.restaurant.app.utils.AuthManager
import md.restaurant.app.data.remote.dto.CartItemRequest
import md.restaurant.app.data.remote.dto.CreateOrderRequest
import md.restaurant.app.data.remote.order.OrderApiClient
import md.restaurant.app.presentation.ui.cart.CartFragment
import md.restaurant.app.presentation.ui.profile.ProfileFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class OrderPaymentFragment : Fragment(), OnMapReadyCallback, DatePickerDialog.OnDateSetListener {

    private var _binding: FragmentOrderPaymentBinding? = null
    private val binding get() = _binding!!

    private var orderType = "delivery"
    private var googleMap: GoogleMap? = null
    private var selectedStartTime: String? = null
    private var selectedEndTime: String? = null
    private var selectedTable: Int? = null
    private var availableTables: List<Int> = emptyList()

    private lateinit var timeList: List<String>

    private var selectedDate: String? = null // yyyy-MM-dd
    private var selectedDateDisplay: String = ""

    private lateinit var locationPermissionLauncher: ActivityResultLauncher<String>

    private val dayOfWeekFormat = SimpleDateFormat("EEE", Locale("ru"))
    private val dayMonthFormat = SimpleDateFormat("dd MMMM", Locale("ru"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) enableMyLocation()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOrderPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = requireContext()
        binding.tvTotal.text = "Итого: ${CartManager.getTotal(context)} MDL"

        val todayCal = Calendar.getInstance()
        if (todayCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            todayCal.add(Calendar.DAY_OF_MONTH, 1)
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        selectedDate = sdf.format(todayCal.time)
        selectedDateDisplay = formatDisplayDate(todayCal)

        updateDateText()

        setupTypeToggle()
        setupTimeSpinners()
        setupDatePicker()

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.btnConfirmOrder.setOnClickListener { confirmOrder() }

        binding.btnBack.setOnClickListener {
            (parentFragment as CartFragment).showCartList()
        }

        binding.etAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val query = s.toString().trim()
                if (query.isNotEmpty() && orderType == "delivery") searchLocationOnMap(query)
            }
        })
    }

    private fun formatDisplayDate(cal: Calendar): String {
        val dayOfWeek = dayOfWeekFormat.format(cal.time).capitalize()
        val dayMonth = dayMonthFormat.format(cal.time)
        return "$dayOfWeek $dayMonth"
    }

    private fun updateDateText() {
        binding.tvDatePickup.text = selectedDateDisplay
        binding.tvDateReserve.text = selectedDateDisplay
    }

    private fun setupDatePicker() {
        binding.tvDatePickup.setOnClickListener { showMaterialDatePicker() }
        binding.tvDateReserve.setOnClickListener { showMaterialDatePicker() }
    }

    private fun showMaterialDatePicker() {
        val todayCal = Calendar.getInstance()
        if (todayCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            todayCal.add(Calendar.DAY_OF_MONTH, 1)
        }

        val maxCal = Calendar.getInstance()
        maxCal.add(Calendar.DAY_OF_MONTH, 7)

        val dpd = DatePickerDialog.newInstance(
            this,
            todayCal.get(Calendar.YEAR),
            todayCal.get(Calendar.MONTH),
            todayCal.get(Calendar.DAY_OF_MONTH)
        )

        dpd.minDate = todayCal
        dpd.maxDate = maxCal

        val disabledDays = mutableListOf<Calendar>()
        val loopCal = todayCal.clone() as Calendar
        while (loopCal <= maxCal) {
            if (loopCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                disabledDays.add(loopCal.clone() as Calendar)
            }
            loopCal.add(Calendar.DAY_OF_MONTH, 1)
        }

        dpd.disabledDays = disabledDays.toTypedArray()

        dpd.show(parentFragmentManager, "Datepickerdialog")
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        val selectedCal = Calendar.getInstance()
        selectedCal.set(year, monthOfYear, dayOfMonth)

        val apiSdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        selectedDate = apiSdf.format(selectedCal.time)
        selectedDateDisplay = formatDisplayDate(selectedCal)

        updateDateText()

        selectedStartTime = null
        selectedEndTime = null
        selectedTable = null
        availableTables = emptyList()
        setupTablesRecycler(emptyList())
    }

    private fun setupTimeSpinners() {
        timeList = mutableListOf<String>().apply {
            for (h in 10..21) {
                add(String.format("%02d:00", h))
                add(String.format("%02d:30", h))
            }
            add("22:00")
        }

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, timeList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerTime.adapter = adapter
        binding.spinnerStartTime.adapter = adapter

        binding.spinnerTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedStartTime = timeList[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spinnerStartTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedStartTime = timeList[position]
                updateEndTimeSpinner(position)
                selectedEndTime = null
                if (selectedEndTime != null && selectedDate != null) {
                    loadAvailableTables(selectedStartTime!!, selectedEndTime!!)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spinnerEndTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedEndTime = (binding.spinnerEndTime.adapter.getItem(position) as String)
                if (selectedStartTime != null && selectedDate != null) {
                    loadAvailableTables(selectedStartTime!!, selectedEndTime!!)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateEndTimeSpinner(startPosition: Int) {
        val newTimes = timeList.subList(startPosition + 2, timeList.size)
        val newAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, newTimes)
        newAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerEndTime.adapter = newAdapter
        if (newTimes.isNotEmpty()) {
            binding.spinnerEndTime.setSelection(0)
            selectedEndTime = newTimes[0]
        }
    }

    private fun add30Minutes(time: String): String {
        val (h, m) = time.split(":").map { it.toInt() }
        var totalMin = h * 60 + m + 30
        val endH = totalMin / 60
        val endM = totalMin % 60
        return String.format("%02d:%02d", endH % 24, endM)
    }

    private fun loadAvailableTables(startTime: String, endTime: String) {
        val date = selectedDate ?: return

        lifecycleScope.launch {
            try {
                val response = OrderApiClient.api.getAvailableTablesInterval(date, startTime, endTime)
                availableTables = response.available
                setupTablesRecycler(availableTables)
                if (availableTables.isEmpty()) {
                    Snackbar.make(binding.root, "Нет свободных столиков на выбранный интервал", Snackbar.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Ошибка проверки", Snackbar.LENGTH_SHORT).show()
                availableTables = emptyList()
                setupTablesRecycler(emptyList())
            }
        }
    }

    private fun setupTablesRecycler(tables: List<Int>) {
        binding.rvTables.layoutManager = GridLayoutManager(requireContext(), 5)
        binding.rvTables.adapter = TableAdapter(tables) { table ->
            selectedTable = table
            (binding.rvTables.adapter as TableAdapter).setSelected(table)
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        map.uiSettings.isZoomControlsEnabled = true

        map.setOnMapClickListener { latLng ->
            map.clear()
            map.addMarker(MarkerOptions().position(latLng).title("Доставка сюда"))
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))

            lifecycleScope.launch {
                val address = getAddressFromLatLng(latLng)
                binding.etAddress.setText(address)
            }
        }

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED) {
            enableMyLocation()
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun enableMyLocation() {
        googleMap?.isMyLocationEnabled = true
    }

    private suspend fun getAddressFromLatLng(latLng: LatLng): String = withContext(kotlinx.coroutines.Dispatchers.IO) {
        try {
            val geocoder = Geocoder(requireContext(), Locale.getDefault())
            val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            addresses?.firstOrNull()?.getAddressLine(0) ?: ""
        } catch (e: Exception) { "" }
    }

    private fun searchLocationOnMap(query: String) {
        lifecycleScope.launch {
            val latLng = getLatLngFromAddress(query)
            if (latLng != null && googleMap != null) {
                googleMap!!.clear()
                googleMap!!.addMarker(MarkerOptions().position(latLng).title("Доставка сюда"))
                googleMap!!.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
            }
        }
    }

    private suspend fun getLatLngFromAddress(address: String): LatLng? = withContext(kotlinx.coroutines.Dispatchers.IO) {
        try {
            val geocoder = Geocoder(requireContext(), Locale.getDefault())
            val addresses = geocoder.getFromLocationName(address, 1)
            if (!addresses.isNullOrEmpty()) LatLng(addresses[0].latitude, addresses[0].longitude) else null
        } catch (e: Exception) { null }
    }

    private fun setupTypeToggle() {
        binding.radioGroupType.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_delivery -> {
                    orderType = "delivery"
                    binding.llDelivery.visibility = View.VISIBLE
                    binding.llPickup.visibility = View.GONE
                    binding.llReserve.visibility = View.GONE
                    binding.llPayment.visibility = View.VISIBLE
                }
                R.id.rb_pickup -> {
                    orderType = "pickup"
                    binding.llDelivery.visibility = View.GONE
                    binding.llPickup.visibility = View.VISIBLE
                    binding.llReserve.visibility = View.GONE
                    binding.llPayment.visibility = View.VISIBLE
                }
                R.id.rb_reserve -> {
                    orderType = "reserve"
                    binding.llDelivery.visibility = View.GONE
                    binding.llPickup.visibility = View.GONE
                    binding.llReserve.visibility = View.VISIBLE
                    binding.llPayment.visibility = View.GONE

                    if (selectedDate != null && selectedStartTime != null && selectedEndTime != null) {
                        loadAvailableTables(selectedStartTime!!, selectedEndTime!!)
                    }
                }
            }
            selectedStartTime = null
            selectedEndTime = null
            selectedTable = null
            availableTables = emptyList()
            setupTablesRecycler(emptyList())
        }
    }

    private fun confirmOrder() {
        val context = requireContext()
        val cart = CartManager.getCart(context)
        if (cart.isEmpty()) {
            (parentFragment as CartFragment).showCartList()
            return
        }

        binding.tilPhone.error = null
        binding.tilAddress.error = null
        binding.tilName.error = null

        var hasError = false

        val name = binding.etName.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()

        if (name.isEmpty()) {
            binding.tilName.error = "Введите имя"
            hasError = true
        }
        if (phone.isEmpty()) {
            binding.tilPhone.error = "Введите телефон"
            hasError = true
        }

        if (orderType == "delivery") {
            val address = binding.etAddress.text.toString().trim()
            if (address.isEmpty()) {
                binding.tilAddress.error = "Введите адрес"
                hasError = true
            }
        } else {
            if (selectedStartTime == null) {
                Snackbar.make(binding.root, "Выберите время прихода", Snackbar.LENGTH_SHORT).show()
                hasError = true
            }
            if (orderType == "reserve") {
                if (selectedEndTime == null) {
                    Snackbar.make(binding.root, "Выберите время ухода", Snackbar.LENGTH_SHORT).show()
                    hasError = true
                }
                if (selectedTable == null) {
                    Snackbar.make(binding.root, "Выберите столик", Snackbar.LENGTH_SHORT).show()
                    hasError = true
                }
            }
        }

        if (hasError) return

        val userId = AuthManager.getUser(context)?.id
        if (userId == null) {
            Snackbar.make(binding.root, "Ошибка авторизации", Snackbar.LENGTH_SHORT).show()
            return
        }

        val itemsRequest = cart.map {
            CartItemRequest(
                menuItemId = it.menuItem._id,
                quantity = it.quantity,
                price = it.menuItem.price
            )
        }

        val finalEndTime = if (orderType == "reserve" && selectedEndTime != null) add30Minutes(selectedEndTime!!) else selectedEndTime

        val request = CreateOrderRequest(
            userId = userId,
            items = itemsRequest,
            total = CartManager.getTotal(context),
            delivery = orderType == "delivery",
            address = if (orderType == "delivery") binding.etAddress.text.toString().trim() else null,
            tableNumber = if (orderType == "reserve") selectedTable else null,
            reservationDate = if (orderType != "delivery") selectedDate else null,
            startTime = if (orderType != "delivery") selectedStartTime else null,
            endTime = if (orderType != "delivery") finalEndTime else null
        )

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = OrderApiClient.api.createOrder(request)
                if (response.success) {
                    CartManager.clearCart(context)
                    Snackbar.make(binding.root, "Ожидайте звонка администрации для подтверждения заказа", Snackbar.LENGTH_LONG).show()

                    parentFragmentManager.popBackStack()
                    (parentFragment?.parentFragment as? ProfileFragment)?.showMyOrders()
                } else {
                    Snackbar.make(binding.root, "Ошибка оформления", Snackbar.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Snackbar.make(binding.root, "Нет связи", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class TableAdapter(
    private val tables: List<Int>,
    private val onClick: (Int) -> Unit
) : androidx.recyclerview.widget.RecyclerView.Adapter<TableAdapter.VH>() {

    private var selected: Int? = null

    inner class VH(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val tv = view.findViewById<android.widget.TextView>(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        view.findViewById<android.widget.TextView>(android.R.id.text1).apply {
            textSize = 18f
            gravity = android.view.Gravity.CENTER
            setPadding(32, 48, 32, 48)
        }
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val table = tables[position]
        holder.tv.text = table.toString()
        holder.itemView.setBackgroundColor(
            if (table == selected) 0xFF4CAF50.toInt() else 0xFFE0E0E0.toInt()
        )
        holder.tv.setTextColor(
            if (table == selected) android.graphics.Color.WHITE else android.graphics.Color.BLACK
        )
        holder.itemView.setOnClickListener {
            onClick(table)
        }
    }

    override fun getItemCount() = tables.size

    fun setSelected(table: Int) {
        selected = table
        notifyDataSetChanged()
    }
}