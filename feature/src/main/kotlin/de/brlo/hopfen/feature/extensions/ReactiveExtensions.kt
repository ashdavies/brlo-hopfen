package de.brlo.hopfen.feature.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

internal operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
  add(disposable)
}
