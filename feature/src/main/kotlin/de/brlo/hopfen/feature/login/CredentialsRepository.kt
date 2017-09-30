package de.brlo.hopfen.feature.login

import de.brlo.hopfen.feature.BuildConfig
import javax.inject.Inject

internal class CredentialsRepository @Inject constructor() {

  val clientId get() = BuildConfig.UNTAPPD_CLIENT_ID

  val clientSecret get() = BuildConfig.UNTAPPD_CLIENT_SECRET
}
