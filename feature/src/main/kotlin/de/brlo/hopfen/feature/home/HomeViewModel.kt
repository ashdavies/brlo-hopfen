package de.brlo.hopfen.feature.home

import android.databinding.ObservableField
import de.brlo.hopfen.feature.android.ViewModel
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.data.Profile
import de.brlo.hopfen.feature.extensions.plusAssign
import de.brlo.hopfen.feature.login.CredentialsRepository
import de.brlo.hopfen.feature.network.SchedulingStrategy
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

internal class HomeViewModel @Inject constructor(
    listings: ListingsRepository,
    profile: ProfileRepository,
    navigation: HomeNavigation,
    credentials: CredentialsRepository,
    strategy: SchedulingStrategy
) : ViewModel<MutableList<Listing>>(State.idle(mutableListOf())) {

  private val disposables = CompositeDisposable()

  val header = ObservableField<State<Profile>>()

  init {
    disposables += listings.getAll()
        .map { state.get().data.apply { add(it) } }
        .compose(strategy.observable())
        .subscribe(
            { state.set(State.idle(it)) },
            {
              navigation.showListingsError()
              state.set(state.get().toError(it))
            }
        )

    disposables += profile.get(credentials.userName)
        .subscribe(
            { header.set(State.idle(it)) },
            {
              navigation.showProfileError()
              header.set(header.get().toError(it))
            }
        )
  }

  override fun onCleared() = disposables.clear()
}
