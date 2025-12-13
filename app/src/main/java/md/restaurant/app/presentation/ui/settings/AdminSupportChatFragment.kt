package md.restaurant.app.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import md.restaurant.app.R
import md.restaurant.app.data.remote.SupportApiClient
import md.restaurant.app.utils.AuthManager
import md.restaurant.app.RestaurantApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import android.util.Base64
import android.graphics.BitmapFactory

class AdminSupportChatFragment : Fragment() {

    private lateinit var chatContainer: LinearLayout
    private var ticketId: String? = null
    private var userId: String? = null
    private var adminId: String = "unknown"

    companion object {
        fun newInstance(ticketId: String) = AdminSupportChatFragment().apply {
            arguments = Bundle().apply { putString("ticket_id", ticketId) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ticketId = arguments?.getString("ticket_id")

        val token = AuthManager.getToken(RestaurantApp.instance)
        if (!token.isNullOrBlank()) {
            try {
                val payload = token.split(".")[1]
                val decoded = String(Base64.decode(payload, Base64.URL_SAFE))
                adminId = JSONObject(decoded).getString("userId")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_admin_support_chat, container, false)

        chatContainer = view.findViewById(R.id.chat_container)

        loadMessagesAndAvatar()

        view.findViewById<View>(R.id.btn_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val etMessage = view.findViewById<EditText>(R.id.et_message)
        view.findViewById<View>(R.id.btn_send).setOnClickListener {
            val text = etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                addAdminMessage(text)
                sendAdminMessage(text)
                etMessage.text.clear()
            }
        }

        return view
    }

    private fun loadMessagesAndAvatar() {
        val id = ticketId ?: return

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val messages = SupportApiClient.api.getMessagesByTicket(id)

                // Получаем userId из тикета (добавь эндпоинт /ticket/info или из первого сообщения)
                // Здесь временно хардкод, замени на реальный запрос
                userId = "69303aa847d72335497b525f" // заменить на реальный

                if (userId != null) {
                    val avatarResponse = SupportApiClient.api.getUserAvatar(userId!!)
                    withContext(Dispatchers.Main) {
                        val ivAvatar = view?.findViewById<ImageView>(R.id.iv_user_avatar)
                        if (avatarResponse.avatar != null) {
                            val bytes = Base64.decode(avatarResponse.avatar, Base64.DEFAULT)
                            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                            ivAvatar?.setImageBitmap(bitmap)
                        } else {
                            ivAvatar?.setImageResource(R.drawable.ic_person)
                        }
                    }
                }

                withContext(Dispatchers.Main) {
                    chatContainer.removeAllViews()
                    messages.forEach { msg ->
                        if (msg.isFromSupport) {
                            addAdminMessage(msg.message)
                        } else {
                            addUserMessage(msg.message)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun addUserMessage(text: String) {
        val messageView = layoutInflater.inflate(R.layout.item_admin_support_message, chatContainer, false)
        messageView.findViewById<TextView>(R.id.tv_message).text = text

        val ivAvatar = messageView.findViewById<ImageView>(R.id.iv_user_avatar)

        if (userId != null) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val avatarResponse = SupportApiClient.api.getUserAvatar(userId!!)
                    withContext(Dispatchers.Main) {
                        if (avatarResponse.avatar != null) {
                            val bytes = Base64.decode(avatarResponse.avatar, Base64.DEFAULT)
                            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                            ivAvatar.setImageBitmap(bitmap)
                        } else {
                            ivAvatar.setImageResource(R.drawable.ic_person)
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        ivAvatar.setImageResource(R.drawable.ic_person)
                    }
                }
            }
        } else {
            ivAvatar.setImageResource(R.drawable.ic_person)
        }

        chatContainer.addView(messageView)
    }

    private fun addAdminMessage(text: String) {
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

    private fun sendAdminMessage(message: String) {
        val id = ticketId ?: return

        CoroutineScope(Dispatchers.IO).launch {
            try {
                SupportApiClient.api.sendAdminMessage(
                    mapOf(
                        "message" to message,
                        "ticketId" to id,
                        "adminId" to adminId
                    )
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}