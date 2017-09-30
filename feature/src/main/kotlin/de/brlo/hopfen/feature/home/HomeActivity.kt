package de.brlo.hopfen.feature.home

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.android.support.DaggerAppCompatActivity
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.activity.ActivityCompanion
import de.brlo.hopfen.feature.databinding.ActivityHomeBinding
import de.brlo.hopfen.feature.extensions.getDataBinding
import de.brlo.hopfen.feature.extensions.getViewModel
import de.brlo.hopfen.feature.home.HomeActivity.Companion.IntentOptions
import de.brlo.hopfen.feature.login.LoginActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

  private lateinit var binding: ActivityHomeBinding

  @Inject internal lateinit var factory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = getDataBinding(R.layout.activity_home)
    binding.model = getViewModel(factory)

    if (FirebaseAuth.getInstance().isNotLoggedIn()) onBackPressed()
  }

  override fun onBackPressed() {
    startActivity(Intent(this, LoginActivity::class.java))
    finish()
  }

  private fun FirebaseAuth.isNotLoggedIn() = currentUser == null

  companion object : ActivityCompanion<IntentOptions>(IntentOptions, HomeActivity::class) {

    object IntentOptions
  }
}
