package de.brlo.hopfen.feature.login

import com.google.android.gms.auth.api.signin.GoogleSignInResult

class GoogleSignInException(result: GoogleSignInResult) : Throwable(result.status.statusMessage)
