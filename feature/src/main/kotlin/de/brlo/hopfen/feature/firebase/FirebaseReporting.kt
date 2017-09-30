package de.brlo.hopfen.feature.firebase

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import de.brlo.hopfen.feature.Reporting
import javax.inject.Inject

internal class FirebaseReporting @Inject constructor(application: Application) : Reporting {

  private val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(application)

  override fun event(name: String) = analytics.logEvent(name, null)

  override fun event(name: String, bundle: Bundle) = analytics.logEvent(name, bundle)
}
