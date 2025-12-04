package md.restaurant.app.presentation.ui.profile.edit

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import md.restaurant.app.data.remote.AuthApiService
import md.restaurant.app.data.remote.dto.EditProfileRequestBody
import md.restaurant.app.databinding.FragmentEditProfileBinding
import md.restaurant.app.utils.AuthManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    // Временное фото — НЕ сохраняем в SharedPreferences!
    private var tempAvatarBase64: String? = null

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val inputStream = requireContext().contentResolver.openInputStream(it)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            binding.ivAvatar.setImageBitmap(bitmap)
            tempAvatarBase64 = bitmapToBase64(bitmap)
        }
    }

    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) {
            pickImage.launch("image/*")
        } else {
            Toast.makeText(requireContext(), "Разрешение отклонено", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root  // ← ЭТА СТРОЧКА ОБЯЗАТЕЛЬНА!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = AuthManager.getUser(requireContext())!!

        binding.etName.setText(user.name)
        binding.etEmail.setText(user.email)
        binding.etPhone.setText(user.phone ?: "")

        // Текущая аватарка из SharedPreferences
        AuthManager.getAvatarBase64(requireContext())?.let {
            binding.ivAvatar.setImageBitmap(base64ToBitmap(it))
        }

        binding.ivAvatar.setOnClickListener {
            openGallery()
        }

        binding.btnSave.setOnClickListener {
            if (!binding.cbConfirm.isChecked) {
                Toast.makeText(requireContext(), "Подтвердите изменения", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val currentAvatarBase64 = AuthManager.getAvatarBase64(requireContext()) ?: ""

            val oldData = mapOf(
                "name" to user.name,
                "email" to user.email,
                "phone" to user.phone,
                "avatar" to currentAvatarBase64
            )

            val newName = binding.etName.text.toString().trim()
            val newEmail = binding.etEmail.text.toString().trim()
            val newPhone = binding.etPhone.text.toString().trim()
            val avatarToSend = tempAvatarBase64 ?: AuthManager.getAvatarBase64(requireContext()) ?: ""

            val newData = mapOf(
                "name" to newName,
                "email" to newEmail,
                "phone" to newPhone,
                "avatar" to avatarToSend
            )

            CoroutineScope(Dispatchers.Main).launch {
                try {
                    withContext(Dispatchers.IO) {
                        Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:5002/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(AuthApiService::class.java)
                            .createEditRequest(
                                EditProfileRequestBody(
                                    userId = user.id,
                                    oldData = oldData,
                                    newData = newData
                                )
                            )
                    }
                    Toast.makeText(requireContext(), "Запрос отправлен! Ожидайте одобрения", Toast.LENGTH_LONG).show()
                    parentFragmentManager.popBackStack()
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "Ошибка: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnCancel.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun openGallery() {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        when {
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED -> {
                pickImage.launch("image/*")
            }
            else -> {
                requestPermission.launch(permission)
            }
        }
    }

    private fun bitmapToBase64(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, baos)
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT)
    }

    private fun base64ToBitmap(base64: String): Bitmap {
        val bytes = Base64.decode(base64, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        tempAvatarBase64 = null
    }
}