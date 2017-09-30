package de.brlo.hopfen.feature.home

import de.brlo.hopfen.feature.data.Profile
import de.brlo.hopfen.feature.repository.Repository
import io.ashdavies.rx.rxfirebase.RxFirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class ProfileRepository @Inject constructor() : Repository<String, Profile> {

  override fun get(key: String): Single<out Profile> {
    return getInstance(CHILD_PROFILE, key)
            .onSingleValueEvent()
            .map { it.getValue<Profile>(Profile::class.java)!! }
  }

  override fun getAll(): Observable<out Profile> = Observable.error(UnsupportedOperationException())

  override fun put(value: Profile, resolver: (Profile) -> String): Completable {
    return getInstance(CHILD_PROFILE, value.uuid).setValue(value)
  }

  private fun getInstance(vararg args: CharSequence): RxFirebaseDatabase {
    return RxFirebaseDatabase.getInstance(args.joinToString("/"))
  }

  companion object {

    private const val CHILD_PROFILE = "profile"

  }
}
