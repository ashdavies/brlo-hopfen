package de.brlo.hopfen.feature.login

import android.net.Uri
import android.view.View
import de.brlo.hopfen.feature.android.ViewModel
import javax.inject.Inject

internal class LoginViewModel @Inject constructor(private val navigation: LoginNavigation) : ViewModel<Any>() {

  fun onLoginClick(view: View) = navigation.navigateToUntappdLogin()

  fun onLoginResult(data: Uri) = navigation.onLoginResult(data)
}
