package md.restaurant.app.presentation.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import md.restaurant.app.R

public class RegisterFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisterToProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_register_to_profile)
  }
}
