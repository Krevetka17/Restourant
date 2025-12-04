package md.restaurant.app.presentation.ui.profile.notifications;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class NotificationBadgeViewModel_Factory implements Factory<NotificationBadgeViewModel> {
  @Override
  public NotificationBadgeViewModel get() {
    return newInstance();
  }

  public static NotificationBadgeViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NotificationBadgeViewModel newInstance() {
    return new NotificationBadgeViewModel();
  }

  private static final class InstanceHolder {
    private static final NotificationBadgeViewModel_Factory INSTANCE = new NotificationBadgeViewModel_Factory();
  }
}
