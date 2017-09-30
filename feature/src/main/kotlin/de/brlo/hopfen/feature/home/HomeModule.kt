package de.brlo.hopfen.feature.home

import android.support.v4.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(HomeViewModelModule::class))
internal class HomeModule {

  @Provides
  fun activity(activity: HomeActivity): FragmentActivity = activity

  @Provides
  fun user() = FirebaseAuth.getInstance().currentUser

  @Provides
  fun reference(user: FirebaseUser) = FirebaseDatabase.getInstance().getReference(user.uid)
}
