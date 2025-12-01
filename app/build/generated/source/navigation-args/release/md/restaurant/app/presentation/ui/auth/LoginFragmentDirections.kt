package md.restaurant.app.presentation.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import md.restaurant.app.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginToRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.action_login_to_register)

    public fun actionLoginToProfile(): NavDirections =
        ActionOnlyNavDirections(R.id.action_login_to_profile)
  }
}
