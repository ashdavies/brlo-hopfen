package de.brlo.hopfen.feature.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class HeadersInterceptor @Inject constructor(@param:NetworkAgent private val agent: String) : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request().newBuilder()
        .header(HEADER_ACCEPT, APPLICATION_JSON)
        .header(HEADER_AGENT, agent)
        .build()

    return chain.proceed(request)
  }

  companion object {

    private val HEADER_ACCEPT = "Accept"
    private val HEADER_AGENT = "User-Agent"

    private val APPLICATION_JSON = "application/json"
  }
}
