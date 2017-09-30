package de.brlo.hopfen.feature.login

import android.content.Intent
import android.net.Uri
import de.brlo.hopfen.feature.home.Navigator
import javax.inject.Inject

internal class LoginNavigation @Inject constructor(private val navigator: Navigator, private val repository: CredentialsRepository) {

  fun navigateToUntappdLogin() {
    navigator.navigate {
      val uri = Uri.parse(UNTAPPD_AUTHENTICATE).buildUpon()
          .appendQueryParameter("client_id", repository.clientId)
          .appendQueryParameter("client_secret", repository.clientSecret)
          .build()

      val intent = Intent.parseUri(uri.toString(), Intent.URI_INTENT_SCHEME)

      it.startActivity(intent)
    }
  }

  companion object {

    // https://untappd.com/oauth/authenticate/?client_id=CLIENTID&response_type=token&redirect_url=REDIRECT_URL
    private const val UNTAPPD_AUTHENTICATE = "https://untappd.com/oauth/authenticate/"
  }
}
