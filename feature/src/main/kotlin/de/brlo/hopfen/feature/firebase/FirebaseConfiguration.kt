package de.brlo.hopfen.feature.firebase

import com.google.firebase.crash.FirebaseCrash
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import de.brlo.hopfen.feature.Configuration
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class FirebaseConfiguration @Inject constructor(private val firebase: FirebaseRemoteConfig) : Configuration {

  init {
    firebase.fetch(CACHE_EXPIRATION_IN_SECONDS)
        .addOnSuccessListener { firebase.activateFetched() }
        .addOnFailureListener(FirebaseCrash::report)
  }

  override fun isEnabled(name: String) = firebase.getBoolean(name)

  companion object {

    private val CACHE_EXPIRATION_IN_SECONDS = TimeUnit.HOURS.toMillis(1)
  }
}
