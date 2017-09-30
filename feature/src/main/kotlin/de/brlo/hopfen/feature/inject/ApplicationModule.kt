package de.brlo.hopfen.feature.inject

import android.app.Application
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import android.view.LayoutInflater
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import de.brlo.hopfen.feature.network.SchedulingStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
internal class ApplicationModule {

  @Provides
  fun inflater(application: Application): LayoutInflater = LayoutInflater.from(application)

  @Provides
  fun preferences(application: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)

  @Provides
  fun resource(application: Application): Resources = application.resources
  
  @Provides
  fun strategy() = SchedulingStrategy(Schedulers.io(), AndroidSchedulers.mainThread())

  @Provides
  fun gson(): Gson = GsonBuilder().create()
}
