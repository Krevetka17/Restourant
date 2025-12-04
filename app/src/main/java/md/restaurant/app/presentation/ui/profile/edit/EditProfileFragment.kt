package md.restaurant.app.presentation.ui.profile.edit

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            val bitmap = BitmapFactory.decodeStream(requireContext().contentResolver.openInputStream(it))
            binding.ivAvatar.setImageBitmap(bitmap)
            val base64 = bitmapToBase64(bitmap)
            AuthManager.saveAvatarBase64(requireContext(), base64)
        }
    }

    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) pickImage.launch("image/*")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = AuthManager.getUser(requireContext())!!

        binding.etName.setText(user.name)
        binding.etEmail.setText(user.email)
        binding.etPhone.setText(user.phone ?: "")

        // Загружаем аватарку
        AuthManager.getAvatarBase64(requireContext())?.let { base64 ->
            binding.ivAvatar.setImageBitmap(base64ToBitmap(base64))
        }

        // Клик по аватарке
        binding.ivAvatar.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED -> {
                    pickImage.launch("image/*")
                }
                else -> requestPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }

        // ОДИН РАЗ — отправка запроса
        binding.btnSave.setOnClickListener {
            if (!binding.cbConfirm.isChecked) {
                Toast.makeText(requireContext(), "Подтвердите изменения", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = AuthManager.getUser(requireContext())!!

            val oldData = mapOf(
                "name" to user.name,
                "email" to user.email,
                "phone" to user.phone
            )

            val newName = binding.etName.text.toString().trim()
            val newEmail = binding.etEmail.text.toString().trim()
            val newPhone = binding.etPhone.text.toString().trim()
            val avatarBase64 = AuthManager.getAvatarBase64(requireContext()) ?: ""

            val newData = mapOf(
                "name" to newName,
                "email" to newEmail,
                "phone" to newPhone,
                "avatar" to avatarBase64
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
                    Toast.makeText(requireContext(), "Запрос успешно отправлен!", Toast.LENGTH_LONG).show()
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
    }
}