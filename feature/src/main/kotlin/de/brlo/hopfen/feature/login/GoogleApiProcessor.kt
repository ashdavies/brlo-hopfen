package de.brlo.hopfen.feature.login

import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import io.reactivex.functions.Action
import io.reactivex.processors.ReplayProcessor

abstract class GoogleApiProcessor private constructor(private val processor: ReplayProcessor<GoogleApiProcessor.Event>) : GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

  protected constructor() : this(ReplayProcessor.create<GoogleApiProcessor.Event>())

  override fun onConnected(bundle: Bundle?) = processor.onNext(GoogleApiProcessor.Event.CONNECTED)

  override fun onConnectionSuspended(cause: Int) = processor.onNext(GoogleApiProcessor.Event.SUSPENDED)

  override fun onConnectionFailed(result: ConnectionResult) = processor.onError(ConnectionFailedException(result))

  fun onConnectionEvent() = processor
      .doOnSubscribe { _ -> connect() }
      .doOnCancel(Action { this.disconnect() })

  protected abstract fun connect()

  protected abstract fun disconnect()

  enum class Event {
    CONNECTED,
    SUSPENDED
  }
}
