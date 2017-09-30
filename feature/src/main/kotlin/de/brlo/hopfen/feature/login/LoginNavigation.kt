package de.brlo.hopfen.feature.login

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.support.v4.app.ActivityCompat.startActivityForResult
import com.google.firebase.auth.FirebaseAuth
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.home.HomeActivity
import de.brlo.hopfen.feature.home.Navigator
import io.ashdavies.rx.rxfirebase.RxFirebaseAuth
import javax.inject.Inject

internal class LoginNavigation @Inject constructor(
    private val navigator: Navigator,
    private val repository: CredentialsRepository,
    private val client: GoogleSignInApi
) {

  fun navigateToUntappdLogin() {
    navigator.navigate {
      val uri = Uri.parse(UNTAPPD_AUTHENTICATE).buildUpon()
          .appendQueryParameter("client_id", repository.clientId)
          .appendQueryParameter("client_secret", repository.clientSecret)
          .appendQueryParameter("redirect_url", "$HOPFEN_SCHEME://$HOPFEN_PATH")
          .build()

      val intent = Intent.parseUri(uri.toString(), Intent.URI_INTENT_SCHEME)

      it.startActivity(intent)
    }
  }

  fun navigateToGoogleLogin() = navigator.navigate { it.startActivityForResult(client.signInIntent, REQUEST_CODE_LOGIN) }

  fun isAlreadySignedIn() {
    client.onConnectionEvent()
        .filter { it == GoogleApiProcessor.Event.CONNECTED }
        .doOnNext { RxFirebaseAuth.getInstance().signOut() }
        .subscribe(
            { client.signOut() },
            { showFailureDialog() }
        )
  }

  fun isFromGoogleSignIn(requestCode: Int) = requestCode == REQUEST_CODE_LOGIN

  fun onLoginResult(data: Uri) {
    if (data.scheme == HOPFEN_SCHEME && data.path == HOPFEN_PATH) {
      repository.accessToken = data.getQueryParameter(UNTAPPD_ACCESS_TOKEN)
      FirebaseAuth.getInstance().signInWithCustomToken(repository.accessToken)
          .addOnSuccessListener { navigateToHomeScreen() }
          .addOnFailureListener { showFailureDialog() }
    }
  }

  fun navigateToHomeScreen() = navigator.navigate { HomeActivity.start(it) {} }

  fun showFailureDialog() {
    navigator.navigate {
      AlertDialog.Builder(it)
          .setTitle(R.string.error_dialog_title)
          .setMessage(R.string.error_login_failed)
          .show()
    }
  }

  companion object {

    private const val REQUEST_CODE_LOGIN = 0x91

    private const val UNTAPPD_AUTHENTICATE = "https://untappd.com/oauth/authenticate/"
    private const val UNTAPPD_ACCESS_TOKEN = "access_token"

    private const val HOPFEN_SCHEME = "brlo.hopfen"
    private const val HOPFEN_PATH = "login"
  }
}
