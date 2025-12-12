package md.restaurant.app.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import md.restaurant.app.R

class SettingsMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        view.findViewById<MaterialButton>(R.id.btn_support).setOnClickListener {
            (parentFragment as SettingsFragment).showSupportChat()
        }

        view.findViewById<MaterialButton>(R.id.btn_change_language).setOnClickListener {
            (parentFragment as SettingsFragment).showLanguageDialogFromChild()
        }

        return view
    }
}