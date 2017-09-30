package de.brlo.hopfen.feature.network

import android.content.SharedPreferences
import javax.inject.Inject

internal class TokenRepository @Inject constructor(private val preferences: SharedPreferences) {

  fun accessToken() = String.format("Bearer %s", preferences.getString(KEY_ACCESS_TOKEN, null))

  fun accessToken(accessToken: String) = preferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply()

  companion object {

    private val KEY_ACCESS_TOKEN = "ACCESS_TOKEN"
  }
}
