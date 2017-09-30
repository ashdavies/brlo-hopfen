package de.brlo.hopfen.feature.inject

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.brlo.hopfen.feature.home.HomeActivity
import de.brlo.hopfen.feature.home.HomeModule

@Module
internal interface ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = arrayOf(HomeModule::class))
  fun homeActivity(): HomeActivity
}
