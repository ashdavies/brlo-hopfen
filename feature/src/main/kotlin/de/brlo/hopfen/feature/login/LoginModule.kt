package de.brlo.hopfen.feature.login

import android.support.v4.app.FragmentActivity
import dagger.Binds
import dagger.Module

@Module(includes = arrayOf(LoginViewModelModule::class))
internal interface LoginModule {

  @Binds
  fun activity(activity: LoginActivity): FragmentActivity
}
