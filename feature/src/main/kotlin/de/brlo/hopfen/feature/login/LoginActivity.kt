package de.brlo.hopfen.feature.login

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import dagger.android.support.DaggerAppCompatActivity
import de.brlo.hopfen.feature.BuildConfig
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.activity.ActivityCompanion
import de.brlo.hopfen.feature.databinding.ActivityLoginBinding
import de.brlo.hopfen.feature.extensions.getDataBinding
import de.brlo.hopfen.feature.extensions.getViewModel
import de.brlo.hopfen.feature.home.HomeActivity
import de.brlo.hopfen.feature.login.LoginActivity.Companion.IntentOptions
import javax.inject.Inject

class LoginActivity : DaggerAppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding

  @Inject internal lateinit var factory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (BuildConfig.DEBUG) FirebaseAuth.getInstance().signInAnonymously()
        .addOnSuccessListener { HomeActivity.start(this) {} }

    binding = getDataBinding(R.layout.activity_login)
    binding.model = getViewModel(factory)

    onNewIntent(intent)
  }

  override fun onNewIntent(intent: Intent) {
    super.onNewIntent(intent)

    val data = intent.data ?: return
    binding.model?.onLoginResult(data)
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    binding.model?.onActivityResult(requestCode, resultCode, data)
    super.onActivityResult(requestCode, resultCode, data)
  }

  companion object : ActivityCompanion<IntentOptions>(IntentOptions, LoginActivity::class) {

    object IntentOptions
  }
}
