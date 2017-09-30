package de.brlo.hopfen.feature.data

import de.brlo.hopfen.feature.home.GsonDeserialiser
import de.brlo.hopfen.feature.repository.Repository
import io.ashdavies.rx.rxfirebase.ChildEvent
import io.ashdavies.rx.rxfirebase.RxFirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class HopsRepository @Inject constructor(private val deserialiser: GsonDeserialiser<Hop>) : Repository<String, Hop> {
    override fun get(key: String): Single<out Hop> {
        return getInstance(CHILD_HOPS, key)
                .onSingleValueEvent()
                .map { it.getValue<Hop>(Hop::class.java)!! }
    }

    override fun getAll(): Observable<out Hop> {
        return RxFirebaseDatabase.getInstance(CHILD_HOPS)
                .orderByChild(QUERY_ORDER)
                .onChildEvent(ChildEvent.Type.CHILD_ADDED)
                .map { deserialiser.deserialise(it.snapshot(), Hop::class.java) }
                .toObservable()
    }

    override fun put(value: Hop, resolver: (Hop) -> String): Completable {
        return getInstance(CHILD_HOPS, value.uuid).setValue(value)
    }

    private fun getInstance(vararg args: CharSequence): RxFirebaseDatabase {
        return RxFirebaseDatabase.getInstance(args.joinToString("/"))
    }

    companion object {

        private const val CHILD_HOPS = "hop"

        private const val QUERY_ORDER = "name"
    }
}