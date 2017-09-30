package de.brlo.hopfen.feature.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import io.reactivex.SingleEmitter
import com.google.android.gms.auth.api.Auth
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe

internal class GoogleSignInResultSingle private constructor(private val result: GoogleSignInResult) : SingleOnSubscribe<GoogleSignInAccount> {

  override fun subscribe(emitter: SingleEmitter<GoogleSignInAccount>) {
    if (!result.isSuccess || result.signInAccount == null) {
      emitter.onError(GoogleSignInException(result))
      return
    }

    emitter.onSuccess(result.signInAccount!!)
  }

  companion object {

    fun from(data: Intent): Single<GoogleSignInAccount> {
      return Single.create(GoogleSignInResultSingle(Auth.GoogleSignInApi.getSignInResultFromIntent(data)))
    }
  }
}
