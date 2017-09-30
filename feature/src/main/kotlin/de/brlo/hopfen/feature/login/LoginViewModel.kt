package de.brlo.hopfen.feature.login

import android.arch.lifecycle.ViewModel
import android.view.View
import javax.inject.Inject

internal class LoginViewModel @Inject constructor(private val navigation: LoginNavigation) : ViewModel() {

  fun onLoginClick(view: View) = navigation.navigateToUntappdLogin()
}
