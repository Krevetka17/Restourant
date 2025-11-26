package md.restaurant.app.presentation.ui.settings

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import md.restaurant.app.MainActivity
import md.restaurant.app.R
import android.widget.LinearLayout
import md.restaurant.app.utils.LanguageManager

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root = LinearLayout(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(resources.getColor(android.R.color.white, null))
            setPadding(64, 120, 64, 64)
        }

        // Кнопка смены языка
        MaterialButton(requireContext()).apply {
            text = getString(R.string.change_language)
            setOnClickListener { showLanguageDialog() }
            root.addView(this)
        }

        // Кнопка стиля экрана
        MaterialButton(requireContext()).apply {
            text = getString(R.string.screen_style)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = 60 }
            setOnClickListener { showScreenStyleDialog() }
            root.addView(this)
        }

        return root
    }

    private fun showLanguageDialog() {
        val languages = arrayOf("English", "Русский", "Română")
        val codes = arrayOf("en", "ru", "ro")

        AlertDialog.Builder(requireContext())
            .setTitle(R.string.choose_language)
            .setItems(languages) { _, which ->
                LanguageManager.setLocale(requireContext(), codes[which])
                (requireActivity() as MainActivity).recreateWithLanguage()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    private fun showScreenStyleDialog() {
        val options = arrayOf(
            getString(R.string.full_screen),
            getString(R.string.notch),
            getString(R.string.default_style)
        )

        AlertDialog.Builder(requireContext())
            .setTitle(R.string.screen_style)
            .setItems(options) { _, which ->
                val themeRes = when (which) {
                    0 -> R.style.Theme_Restaurant_FullScreen
                    1 -> R.style.Theme_Restaurant_Notch
                    else -> R.style.Theme_Restaurant_Default
                }
                saveAndApplyTheme(themeRes)
            }
            .show()
    }

    private fun saveAndApplyTheme(themeRes: Int) {
        requireContext().getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            .edit()
            .putInt("screen_style", themeRes)
            .apply()

        requireActivity().recreate()
    }
}