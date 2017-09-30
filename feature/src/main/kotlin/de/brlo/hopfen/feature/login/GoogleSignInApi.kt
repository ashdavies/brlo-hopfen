package de.brlo.hopfen.feature.login

import android.app.Application
import com.google.android.gms.auth.api.Auth
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.PendingResult
import com.google.android.gms.common.api.Status
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.android.StringResolver
import javax.inject.Inject

internal class GoogleSignInApi @Inject constructor(application: Application, resolver: StringResolver) : GoogleApiProcessor() {

  private val client: GoogleApiClient

  val signInIntent: Intent get() = Auth.GoogleSignInApi.getSignInIntent(client)

  init {
    client = GoogleApiClient.Builder(application)
        .addConnectionCallbacks(this)
        .addOnConnectionFailedListener(this)
        .addApi(Auth.GOOGLE_SIGN_IN_API, createGoogleSignInOptions(resolver))
        .build()
  }

  private fun createGoogleSignInOptions(resolver: StringResolver): GoogleSignInOptions {
    return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(resolver.get(R.string.default_web_client_id))
        .requestEmail()
        .build()
  }

  fun signOut(): PendingResult<Status> = Auth.GoogleSignInApi.signOut(client)

  override fun connect() = client.connect()

  override fun disconnect() = client.disconnect()
}
