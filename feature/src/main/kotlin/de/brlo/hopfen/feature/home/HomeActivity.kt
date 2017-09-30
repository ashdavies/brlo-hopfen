package de.brlo.hopfen.feature.home

import android.os.Bundle
import de.brlo.hopfen.feature.activity.ActivityCompanion
import de.brlo.hopfen.feature.home.HomeActivity.Companion.IntentOptions

class HomeActivity : DaggerAppCompatActivity() {

  private val disposables: CompositeDisposable = CompositeDisposable()

  private lateinit var binding: ActivityHomeBinding

  @Inject internal lateinit var factory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = getDataBinding(R.layout.activity_home)
    binding.model = getViewModel(factory)
  }

  companion object : ActivityCompanion<IntentOptions>(IntentOptions, HomeActivity::class) {

    object IntentOptions
  }
}
