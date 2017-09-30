package de.brlo.hopfen.feature.home

import android.support.v4.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import de.brlo.hopfen.feature.data.Listing

@Module(includes = arrayOf(HomeViewModelModule::class))
internal class HomeModule {

  @Provides
  fun activity(activity: HomeActivity): FragmentActivity = activity

  @Provides
  fun user() = FirebaseAuth.getInstance().currentUser

  @Provides
  fun reference(user: FirebaseUser): DatabaseReference = FirebaseDatabase.getInstance().getReference(user.uid)
}
