package de.brlo.hopfen.feature.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


internal interface Repository<in K, V> {

  fun get(key: K): Single<out V>

  fun getAll(): Observable<out V>

  fun put(value: V, resolver: (V) -> K): Completable
}
