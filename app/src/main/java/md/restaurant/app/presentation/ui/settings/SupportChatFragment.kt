package md.restaurant.app.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import md.restaurant.app.R
import md.restaurant.app.data.remote.SupportApiClient
import md.restaurant.app.data.remote.dto.SupportMessageDto
import md.restaurant.app.utils.AuthManager
import md.restaurant.app.RestaurantApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import android.util.Base64

class SupportChatFragment : Fragment() {

    private lateinit var chatContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_support_chat, container, false)

        chatContainer = view.findViewById(R.id.chat_container)

        // Всегда показываем приветствие при обычном входе
        addSupportMessage("Здравствуйте! Чем можем помочь?")

        view.findViewById<View>(R.id.btn_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        view.findViewById<View>(R.id.btn_chat_history).setOnClickListener {
            (parentFragment as SettingsFragment).showSupportHistory()
        }

        val etMessage = view.findViewById<EditText>(R.id.et_message)
        view.findViewById<View>(R.id.btn_send).setOnClickListener {
            val text = etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                addUserMessage(text)
                sendMessageToServer(text)
                etMessage.text.clear()
            }
        }

        return view
    }

    private fun addSupportMessage(text: String) {
        val messageView = layoutInflater.inflate(R.layout.item_support_message, chatContainer, false)
        messageView.findViewById<TextView>(R.id.tv_message).text = text
        chatContainer.addView(messageView)
    }

    private fun addUserMessage(text: String) {
        val messageView = TextView(requireContext()).apply {
            this.text = text
            textSize = 16f
            setTextColor(resources.getColor(android.R.color.white, null))
            setPadding(48, 12, 48, 12)
            setBackgroundResource(R.drawable.bg_user_bubble)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = android.view.Gravity.END
                marginStart = 80
                marginEnd = 16
                bottomMargin = 16
            }
        }
        chatContainer.addView(messageView)
    }

    private fun sendMessageToServer(message: String) {
        val token = AuthManager.getToken(RestaurantApp.instance)
        var userId: String = "unknown"
        if (!token.isNullOrBlank()) {
            try {
                val payload = token.split(".")[1]
                val decoded = String(Base64.decode(payload, Base64.URL_SAFE))
                userId = JSONObject(decoded).getString("userId")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            try {
                SupportApiClient.api.sendMessage(
                    mapOf(
                        "message" to message,
                        "userId" to userId
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}