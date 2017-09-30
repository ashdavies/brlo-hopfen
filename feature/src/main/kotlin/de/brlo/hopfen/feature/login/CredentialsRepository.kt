package de.brlo.hopfen.feature.login

import android.content.SharedPreferences
import de.brlo.hopfen.feature.BuildConfig
import javax.inject.Inject

internal class CredentialsRepository @Inject constructor(preferences: SharedPreferences) {

  val clientId get() = BuildConfig.UNTAPPD_CLIENT_ID

  val clientSecret get() = BuildConfig.UNTAPPD_CLIENT_SECRET

  var accessToken by StringPreference(preferences, UNTAPPD_ACCESS_TOKEN, "")

  var userName by StringPreference(preferences, UNTAPPD_USERNAME, "")

  companion object {

    private const val UNTAPPD_ACCESS_TOKEN = "untappd.access.token"
    private const val UNTAPPD_USERNAME = "untappd.username"
  }
}
