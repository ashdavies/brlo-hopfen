package de.brlo.hopfen.feature.home

import android.databinding.ObservableField
import android.view.View
import de.brlo.hopfen.feature.android.ViewModel
import de.brlo.hopfen.feature.data.Hop
import de.brlo.hopfen.feature.data.HopsRepository
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.data.Profile
import de.brlo.hopfen.feature.extensions.plusAssign
import de.brlo.hopfen.feature.network.SchedulingStrategy
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

internal class HomeViewModel @Inject constructor(
        private val listings: ListingsRepository,
        profiles: ProfileRepository,
        hops: HopsRepository,
        private val navigation: HomeNavigation,
        strategy: SchedulingStrategy
) : ViewModel<MutableList<Listing>>(State.idle(mutableListOf())) {

  private val disposables = CompositeDisposable()

  val header = ObservableField<State<Profile>>(State.idle(Profile.empty()))

  val hopsList = ObservableField<State<MutableList<Hop>>>(State.idle(MutableList(0, { _ -> Hop.empty() })))

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

    disposables += profiles.get("fGo29hRp2BMhHFkkmziAP3fBGbf2")
        .subscribe(
            { header.set(State.idle(it)) },
            {
              navigation.showProfileError()
              header.set(header.get().toError(it))
            }
        )

    disposables += hops.getAll()
        .map { hopsList.get().data.apply { add(it) } }
        .compose(strategy.observable())
        .subscribe(
            { hopsList.set(State.idle(it)) },
            {
              navigation.showHopsError()
              hopsList.set(hopsList.get().toError(it))
            }
        )
  }

  override fun onCleared() = disposables.clear()

  fun onActionClicked(view: View) = navigation.showAddListingDialog(
      hopsList.get().data,
      header.get().data,
      { listing: Listing -> listings.put(listing, { _ -> "" }).subscribe() })
}
