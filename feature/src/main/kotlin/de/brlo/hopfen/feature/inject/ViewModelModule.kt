package de.brlo.hopfen.feature.inject

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import de.brlo.hopfen.feature.ui.ViewModelFactory

@Module
internal interface ViewModelModule {

  @Binds
  fun model(model: ViewModelFactory): ViewModelProvider.Factory
}
