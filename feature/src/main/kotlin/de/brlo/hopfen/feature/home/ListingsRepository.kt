package de.brlo.hopfen.feature.home

import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.repository.Repository
import io.ashdavies.rx.rxfirebase.ChildEvent
import io.ashdavies.rx.rxfirebase.RxFirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class ListingsRepository @Inject constructor(private val deserialiser: GsonDeserialiser<Listing>) : Repository<String, Listing> {

  override fun get(key: String): Single<Listing> {
    return getInstance(CHILD_LISTINGS, key)
        .onSingleValueEvent()
        .map { it.getValue<Listing>(Listing::class.java)!! }
  }

  override fun getAll(): Observable<Listing> {
    return RxFirebaseDatabase.getInstance(CHILD_LISTINGS)
        .limitToLast(QUERY_LIMIT)
        .orderByChild(QUERY_ORDER)
        .onChildEvent(ChildEvent.Type.CHILD_ADDED)
        .map { deserialiser.deserialise(it.snapshot(), Listing::class.java) }
        .toObservable()
  }

  override fun put(value: Listing, resolver: (Listing) -> String): Completable {
    return getInstance(CHILD_LISTINGS, value.uuid).setValue(value)
  }

  private fun getInstance(vararg args: CharSequence): RxFirebaseDatabase {
    return RxFirebaseDatabase.getInstance(args.joinToString("/"))
  }

  companion object {

    private const val CHILD_LISTINGS = "listing"

    private const val QUERY_ORDER = "created"
    private const val QUERY_LIMIT = 100
  }
}
