package de.brlo.hopfen.feature.android

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

internal abstract class ViewModel<T> private constructor(val state: ObservableField<State<T>>) : ViewModel() {

  constructor() : this(ObservableField())

  constructor(state: State<T>) : this(ObservableField(state))

  sealed class State<out T>(open val data: T) {

    fun toLoading() = State.loading(data)

    data class Loading<out T>(override val data: T) : State<T>(data)

    fun toIdle() = State.idle(data)

    data class Idle<out T>(override val data: T) : State<T>(data)

    fun toError(throwable: Throwable) = State.error(data, throwable)

    data class Error<out T>(override val data: T, val throwable: Throwable) : State<T>(data)

    companion object {

      fun <T> idle(data: T): State<T> = Idle(data)

      fun <T> loading(data: T): State<T> = Loading(data)

      fun <T> error(data: T, throwable: Throwable): State<T> = Error(data, throwable)
    }
  }
}
