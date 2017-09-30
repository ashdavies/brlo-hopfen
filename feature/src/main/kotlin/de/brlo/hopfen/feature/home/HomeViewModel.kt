package de.brlo.hopfen.feature.home

import de.brlo.hopfen.feature.android.ViewModel
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.extensions.plusAssign
import de.brlo.hopfen.feature.network.SchedulingStrategy
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

internal class HomeViewModel @Inject constructor(repository: ListingsRepository, navigation: HomeNavigation) : ViewModel<MutableList<Listing>>(State.idle(mutableListOf())) {

  private val disposables = CompositeDisposable()

  init {
    disposables += repository.getAll()
        .map { state.get().data.apply { add(it) } }
        .subscribe(
            { state.set(State.idle(it)) },
            {
              navigation.showListingsError()
              state.set(state.get().toError(it))
            }
        )
  }

  override fun onCleared() = disposables.clear()
}
