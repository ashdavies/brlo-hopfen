package de.brlo.hopfen.feature.login

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.activity.ActivityCompanion
import de.brlo.hopfen.feature.databinding.ActivityLoginBinding
import de.brlo.hopfen.feature.extensions.getDataBinding
import de.brlo.hopfen.feature.extensions.getViewModel
import de.brlo.hopfen.feature.login.LoginActivity.Companion.IntentOptions
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding

  @Inject internal lateinit var factory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = getDataBinding(R.layout.activity_login)
    binding.model = getViewModel(factory)
  }

  companion object : ActivityCompanion<IntentOptions>(IntentOptions, LoginActivity::class) {

    object IntentOptions
  }
}
