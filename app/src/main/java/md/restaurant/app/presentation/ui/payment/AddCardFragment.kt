package md.restaurant.app.presentation.ui.profile.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.data.remote.AuthApiClient
import md.restaurant.app.databinding.FragmentAddCardBinding
import md.restaurant.app.utils.AuthManager

class AddCardFragment : Fragment() {

    private var _binding: FragmentAddCardBinding? = null
    private val binding get() = _binding!!

    private lateinit var paymentSheet: PaymentSheet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PaymentConfiguration.init(
            requireContext(),
            "pk_test_51SVAvNPrt0uoZqs8YO5zwVywAZrxuVuzVdzjVt1mSOCtqwQNsgIRCbNesA4JHNNa5ZMTH6vjKltCFGMoawwoLx3c00IrDvglGG"
        )
        paymentSheet = PaymentSheet(this, ::onPaymentSheetResult)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnSaveCard.setOnClickListener {
            presentPaymentSheet()
        }
    }

    private fun presentPaymentSheet() {
        val config = PaymentSheet.Configuration(
            merchantDisplayName = "Ресторан",
            allowsDelayedPaymentMethods = true
        )

        createSetupIntent { clientSecret ->
            if (clientSecret != null) {
                paymentSheet.presentWithSetupIntent(clientSecret, config)
            } else {
                Toast.makeText(context, "Ошибка создания SetupIntent", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun createSetupIntent(callback: (String?) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = AuthApiClient.api.createSetupIntent()
                withContext(Dispatchers.Main) {
                    callback(response.clientSecret)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback(null)
                    Toast.makeText(context, "Нет связи с сервером", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun onPaymentSheetResult(result: PaymentSheetResult) {
        when (result) {
            is PaymentSheetResult.Completed -> {
                Toast.makeText(context, "Карта добавлена!", Toast.LENGTH_SHORT).show()

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        delay(3000) // даём Stripe время обработать
                        val freshUser = AuthApiClient.api.getCurrentUser()
                        withContext(Dispatchers.Main) {
                            AuthManager.saveAuth(requireContext(), AuthManager.getToken(requireContext())!!, freshUser)
                            parentFragmentManager.popBackStack()
                        }
                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Не удалось обновить: ${e.message}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
            is PaymentSheetResult.Canceled -> {
                Toast.makeText(context, "Отменено", Toast.LENGTH_SHORT).show()
            }
            is PaymentSheetResult.Failed -> {
                Toast.makeText(context, "Ошибка: ${result.error.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}