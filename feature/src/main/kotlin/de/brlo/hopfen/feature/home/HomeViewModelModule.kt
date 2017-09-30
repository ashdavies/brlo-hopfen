package de.brlo.hopfen.feature.home

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.brlo.hopfen.feature.inject.ActivityScope
import de.brlo.hopfen.feature.inject.ViewModelKey

@Module
internal interface HomeViewModelModule {

  @Binds
  @IntoMap
  @ActivityScope
  @ViewModelKey(HomeViewModel::class)
  fun model(model: HomeViewModel): ViewModel
}
