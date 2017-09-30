package de.brlo.hopfen.feature.login

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.brlo.hopfen.feature.inject.ViewModelKey

@Module
internal interface LoginViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel::class)
  fun model(model: LoginViewModel): ViewModel
}
