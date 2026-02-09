package md.restaurant.app.presentation.ui.profile.payment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.R
import md.restaurant.app.data.remote.dto.PaymentMethodDto
import md.restaurant.app.databinding.ItemPaymentCardBinding

class PaymentMethodsAdapter(
    private val onSelect: (String?) -> Unit,               // передаём null при снятии выбора
    private val onDelete: (String) -> Unit,
    private var selectedId: String? = null
) : ListAdapter<PaymentMethodDto, PaymentMethodsAdapter.CardVH>(Diff()) {

    class CardVH(val b: ItemPaymentCardBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardVH {
        val b = ItemPaymentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardVH(b)
    }

    override fun onBindViewHolder(vh: CardVH, pos: Int) {
        val card = getItem(pos)
        with(vh.b) {
            tvCardNumber.text = card.cardNumber
            tvExpiry.text = card.expiry
            tvHolder.text = card.brand?.replaceFirstChar { it.uppercase() } ?: "Карта"

            val isSelected = card.id == selectedId

            root.setBackgroundResource(
                if (isSelected) R.drawable.card_selected_bg
                else if (selectedId != null) R.drawable.card_grayed_bg
                else R.drawable.card_normal_bg
            )

            btnDelete.setOnClickListener { onDelete(card.id) }

            // Вся карточка кликабельна
            root.isClickable = true
            root.isFocusable = true
            root.setOnClickListener {
                selectedId = if (isSelected) null else card.id
                onSelect(selectedId)
                notifyDataSetChanged()
            }
        }
    }

    fun updateSelected(id: String?) {
        selectedId = id
        notifyDataSetChanged()
    }

    class Diff : DiffUtil.ItemCallback<PaymentMethodDto>() {
        override fun areItemsTheSame(a: PaymentMethodDto, b: PaymentMethodDto) = a.id == b.id
        override fun areContentsTheSame(a: PaymentMethodDto, b: PaymentMethodDto) = a == b
    }
}