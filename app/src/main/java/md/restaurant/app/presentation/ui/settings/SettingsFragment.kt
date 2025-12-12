package md.restaurant.app.presentation.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import md.restaurant.app.R
import md.restaurant.app.databinding.FragmentSettingsContainerBinding
import md.restaurant.app.utils.LanguageManager
import md.restaurant.app.MainActivity

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null) {
            showSettingsMain()
        }
    }

    fun showSettingsMain() {
        childFragmentManager.commit {
            replace(R.id.settings_container, SettingsMainFragment())
        }
    }

    fun showSupportChat() {
        childFragmentManager.commit {
            replace(R.id.settings_container, SupportChatFragment())
            addToBackStack("support_chat")
        }
    }

    fun showSupportHistory() {
        childFragmentManager.commit {
            replace(R.id.settings_container, SupportHistoryFragment())
            addToBackStack("support_history")
        }
    }

    fun showSpecificSupportChat(ticketId: String) {
        childFragmentManager.commit {
            replace(R.id.settings_container, SupportSpecificChatFragment.newInstance(ticketId))
            addToBackStack("specific_chat")
        }
    }

    fun showLanguageDialogFromChild() {
        showLanguageDialog()
    }

    private fun showLanguageDialog() {
        val languages = arrayOf("English", "Русский", "Română")
        val codes = arrayOf("en", "ru", "ro")

        android.app.AlertDialog.Builder(requireContext())
            .setTitle(md.restaurant.app.R.string.choose_language)
            .setItems(languages) { _, which ->
                LanguageManager.setLocale(requireContext(), codes[which])
                (requireActivity() as MainActivity).recreateWithLanguage()
            }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}