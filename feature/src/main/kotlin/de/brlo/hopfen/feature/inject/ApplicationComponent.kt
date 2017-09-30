package de.brlo.hopfen.feature.inject

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import de.brlo.hopfen.feature.hopfen
import de.brlo.hopfen.feature.firebase.FirebaseModule
import de.brlo.hopfen.feature.network.NetworkModule
import javax.inject.Singleton

@ApplicationScope
@Component(modules = arrayOf(
    ApplicationModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    FirebaseModule::class,
    NetworkModule::class,
    ViewModelModule::class
))
internal interface ApplicationComponent : AndroidInjector<hopfen> {

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): ApplicationComponent
  }
}
