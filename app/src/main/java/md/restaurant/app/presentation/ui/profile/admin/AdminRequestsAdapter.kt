package md.restaurant.app.presentation.ui.profile.admin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.data.remote.dto.EditProfileRequestDto
import md.restaurant.app.databinding.ItemAdminRequestBinding

class AdminRequestsAdapter(
    private val onApprove: (String) -> Unit,
    private val onReject: (String) -> Unit
) : ListAdapter<EditProfileRequestDto, AdminRequestsAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdminRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAdminRequestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(request: EditProfileRequestDto) {
            val user = request.userId
            binding.tvUser.text = user?.name ?: "Неизвестно"
            binding.tvOld.text = "Старое: ${request.oldData.name} (${request.oldData.email})"
            binding.tvNew.text = "Новое: ${request.newData.name} (${request.newData.email})"
            binding.tvDate.text = request.requestedAt.split("T")[0] // красивая дата

            binding.btnApprove.setOnClickListener {
                request._id?.let { onApprove(it) }
            }
            binding.btnReject.setOnClickListener {
                request._id?.let { onReject(it) }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<EditProfileRequestDto>() {
        override fun areItemsTheSame(old: EditProfileRequestDto, new: EditProfileRequestDto) = old._id == new._id
        override fun areContentsTheSame(old: EditProfileRequestDto, new: EditProfileRequestDto) = old == new
    }
}