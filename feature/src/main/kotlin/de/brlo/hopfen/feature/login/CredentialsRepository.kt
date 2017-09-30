package de.brlo.hopfen.feature.login

import android.content.SharedPreferences
import de.brlo.hopfen.feature.BuildConfig
import javax.inject.Inject

internal class CredentialsRepository @Inject constructor(private val preferences: SharedPreferences) {

  val clientId get() = BuildConfig.UNTAPPD_CLIENT_ID

  val clientSecret get() = BuildConfig.UNTAPPD_CLIENT_SECRET

  var accessToken: String
    get() = preferences.getString(UNTAPPD_ACCESS_TOKEN, "")
    set(value) = preferences.edit().putString(UNTAPPD_ACCESS_TOKEN, value).apply()

  companion object {

    private const val UNTAPPD_ACCESS_TOKEN = "untappd.access.token"
  }
}
