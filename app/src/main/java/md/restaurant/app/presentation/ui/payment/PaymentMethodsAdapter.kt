package md.restaurant.app.presentation.ui.profile.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.data.remote.dto.PaymentMethodDto
import md.restaurant.app.databinding.ItemPaymentCardBinding

class PaymentMethodsAdapter(
    private val onDeleteClick: (String) -> Unit
) : ListAdapter<PaymentMethodDto, PaymentMethodsAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(val binding: ItemPaymentCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPaymentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = getItem(position)
        with(holder.binding) {
            tvCardNumber.text = card.cardNumber
            tvExpiry.text = card.expiry
            tvHolder.text = card.brand?.replaceFirstChar { it.uppercase() } ?: "Карта"  // бренд вместо holder
            btnDelete.setOnClickListener { onDeleteClick(card.id) }  // id вместо _id
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PaymentMethodDto>() {
        override fun areItemsTheSame(old: PaymentMethodDto, new: PaymentMethodDto) = old.id == new.id
        override fun areContentsTheSame(old: PaymentMethodDto, new: PaymentMethodDto) = old == new
    }
}