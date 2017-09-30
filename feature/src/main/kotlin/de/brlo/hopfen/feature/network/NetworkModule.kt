package de.brlo.hopfen.feature.network

import dagger.Module
import dagger.Provides
import dagger.Reusable
import de.brlo.hopfen.feature.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
internal class NetworkModule {

  private val TIMEOUT_IN_SECONDS = 5

  @Provides
  @NetworkAgent
  fun agent() = "ANDROID"

  @Provides
  fun logging() = HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

  @Provides
  @Reusable
  @AnonymousNetworkClient
  fun anonymous(headers: HeadersInterceptor, logging: HttpLoggingInterceptor) = OkHttpClient.Builder()
      .connectTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
      .readTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
      .writeTimeout(TIMEOUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
      .addInterceptor(headers)
      .addInterceptor(logging)
      .build()

  @Provides
  @Reusable
  @AuthenticatedNetworkClient
  fun authenticated(@AnonymousNetworkClient client: OkHttpClient, interceptor: AuthenticationInterceptor) = client.newBuilder()
      .addInterceptor(interceptor)
      .build()
}
