package de.brlo.hopfen.feature.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class AuthenticationInterceptor @Inject constructor(private val repository: TokenRepository) : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request().newBuilder()
        .addHeader(HEADER_AUTHORIZATION, repository.accessToken())
        .build()

    return chain.proceed(request)
  }

  companion object {

    private val HEADER_AUTHORIZATION = "Authorization"
  }
}
