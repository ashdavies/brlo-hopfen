package de.brlo.hopfen.feature.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import dagger.Module
import dagger.Provides
import de.brlo.hopfen.feature.BuildConfig
import de.brlo.hopfen.feature.R

@Module
internal class FirebaseConfigurationModule {

  @Provides
  fun config(): FirebaseRemoteConfig {
    val firebase = FirebaseRemoteConfig.getInstance()
    val config = FirebaseRemoteConfigSettings.Builder()
        .setDeveloperModeEnabled(BuildConfig.DEBUG)
        .build()

    firebase.setConfigSettings(config)
    firebase.setDefaults(R.xml.remote_config_defaults)

    return firebase
  }
}
