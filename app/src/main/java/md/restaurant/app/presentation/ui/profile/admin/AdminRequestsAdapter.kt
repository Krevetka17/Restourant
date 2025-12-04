package md.restaurant.app.presentation.ui.profile.admin

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import md.restaurant.app.R
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

            // Текстовые данные
            binding.tvOld.text = "Старое: ${request.oldData.name} (${request.oldData.email})"
            binding.tvNew.text = "Новое: ${request.newData.name} (${request.newData.email})"
            binding.tvDate.text = request.requestedAt.split("T")[0]

            // Старая аватарка — из oldData.avatar
            val oldAvatarBase64 = request.oldData.avatar
            if (!oldAvatarBase64.isNullOrBlank() && oldAvatarBase64.length > 100) {
                try {
                    val bitmap = base64ToBitmap(oldAvatarBase64)
                    binding.ivOldAvatar.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    binding.ivOldAvatar.setImageResource(R.drawable.ic_default_user)
                }
            } else {
                binding.ivOldAvatar.setImageResource(R.drawable.ic_default_user)
            }

            // Новая аватарка — из newData.avatar
            val newAvatarBase64 = request.newData.avatar
            if (!newAvatarBase64.isNullOrBlank() && newAvatarBase64.length > 100) {
                try {
                    val bitmap = base64ToBitmap(newAvatarBase64)
                    binding.ivNewAvatar.setImageBitmap(bitmap)
                    binding.ivNewAvatar.isVisible = true
                } catch (e: Exception) {
                    binding.ivNewAvatar.isVisible = false
                }
            } else {
                binding.ivNewAvatar.isVisible = false
            }

            binding.btnApprove.setOnClickListener {
                request._id?.let { onApprove(it) }
            }
            binding.btnReject.setOnClickListener {
                request._id?.let { onReject(it) }
            }
        }
    }

    private fun base64ToBitmap(base64: String): android.graphics.Bitmap {
        val bytes = Base64.decode(base64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    class DiffCallback : DiffUtil.ItemCallback<EditProfileRequestDto>() {
        override fun areItemsTheSame(old: EditProfileRequestDto, new: EditProfileRequestDto) = old._id == new._id
        override fun areContentsTheSame(old: EditProfileRequestDto, new: EditProfileRequestDto) = old == new
    }
}