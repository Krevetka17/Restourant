package md.restaurant.app.presentation.ui.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import md.restaurant.app.R

public class ProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionProfileToLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_profile_to_login)
  }
}
