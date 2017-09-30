package de.brlo.hopfen.feature.home

import de.brlo.hopfen.feature.BuildConfig
import de.brlo.hopfen.feature.data.Profile
import de.brlo.hopfen.feature.repository.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class ProfileRepository @Inject constructor() : Repository<String, Profile> {

  override fun get(key: String): Single<out Profile> = if (BuildConfig.DEBUG) Single.just(Profile(BRLO_UUID, BRLO_HEADER, BRLO_IMPRESSUM, BRLO_LOCATIONS)) else Single.never()

  override fun getAll(): Observable<out Profile> = Observable.error(UnsupportedOperationException())

  override fun put(value: Profile, resolver: (Profile) -> String): Completable = Completable.error(UnsupportedOperationException())

  companion object {

    private const val BRLO_UUID = "BRLO_UUID"
    private const val BRLO_HEADER = "http://supr.com/brlo/files/brlo_home_porter.jpg"
    private const val BRLO_IMPRESSUM = "Braukunst Berlin GmbH"
    private val BRLO_LOCATIONS = Array(1, { _ -> Profile.Location("BRLO_LOCATION_UUID", "BR\u20ACO Brwhouse", "Schöneberger Str. 16, 10963 Berlin, Germany") })
  }
}