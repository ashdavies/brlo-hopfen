package de.brlo.hopfen.feature.login

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.View
import com.google.firebase.auth.GoogleAuthProvider
import de.brlo.hopfen.feature.android.ViewModel
import io.ashdavies.rx.rxfirebase.RxFirebaseAuth
import javax.inject.Inject

internal class LoginViewModel @Inject constructor(private val navigation: LoginNavigation) : ViewModel<Any>() {

  init { navigation.isAlreadySignedIn()}

  fun onLoginClick(view: View) = navigation.navigateToUntappdLogin()

  fun onGoogleLoginClick(view: View) = navigation.navigateToGoogleLogin()

  fun onLoginResult(data: Uri) = navigation.onLoginResult(data)

  @SuppressLint("CheckResult")
  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if (navigation.isFromGoogleSignIn(requestCode)) {
      GoogleSignInResultSingle.from(data)
          .flatMap { RxFirebaseAuth.getInstance().signInWithCredential(GoogleAuthProvider.getCredential(it.idToken, null)); }
          .subscribe(
              { navigation.navigateToHomeScreen() },
              { navigation.showFailureDialog() }
          )
    }
  }
}
