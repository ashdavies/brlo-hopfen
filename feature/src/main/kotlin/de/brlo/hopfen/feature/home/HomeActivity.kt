package de.brlo.hopfen.feature.home

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import com.stepango.rxdatabindings.observe
import dagger.android.support.DaggerAppCompatActivity
import de.brlo.hopfen.feature.BuildConfig
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.activity.ActivityCompanion
import de.brlo.hopfen.feature.databinding.ActivityHomeBinding
import de.brlo.hopfen.feature.extensions.getDataBinding
import de.brlo.hopfen.feature.extensions.getFont
import de.brlo.hopfen.feature.extensions.getViewModel
import de.brlo.hopfen.feature.home.HomeActivity.Companion.IntentOptions
import de.brlo.hopfen.feature.login.LoginActivity
import de.brlo.hopfen.feature.network.SchedulingStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_home.backdrop
import kotlinx.android.synthetic.main.activity_home.collapsing
import kotlinx.android.synthetic.main.activity_home.recycler
import kotlinx.android.synthetic.main.activity_home.toolbar
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

  private lateinit var binding: ActivityHomeBinding

  @Inject internal lateinit var factory: ViewModelProvider.Factory
  @Inject internal lateinit var strategy: SchedulingStrategy
  @Inject internal lateinit var adapter: ListingsAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (!BuildConfig.DEBUG && FirebaseAuth.getInstance().isNotLoggedIn()) onBackPressed()

    binding = getDataBinding(R.layout.activity_home)
    binding.model = getViewModel(factory)

    setSupportActionBar(toolbar)
    setCollapsingToolbarFont()

    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(this)

    binding.model?.state?.observe(AndroidSchedulers.mainThread())?.subscribe { adapter.items = it.data }
    binding.model?.header?.observe(AndroidSchedulers.mainThread())?.subscribe {
      setHeaderText(it.data.name)
      setHeaderImage(it.data.image)
    }
  }

  private fun setCollapsingToolbarFont() {
    collapsing.setCollapsedTitleTypeface(getFont(R.font.product_sans_regular))
    collapsing.setExpandedTitleTypeface(getFont(R.font.product_sans_regular))
  }

  private fun setHeaderText(text: String) {
    collapsing.title = text
  }

  private fun setHeaderImage(url: String) {
    if (url.isEmpty()) return

    Picasso.with(this)
        .load(url)
        .fit()
        .centerCrop()
        .into(backdrop)
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
