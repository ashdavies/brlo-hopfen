package de.brlo.hopfen.feature.inject

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.brlo.hopfen.feature.home.HomeActivity
import de.brlo.hopfen.feature.home.HomeModule
import de.brlo.hopfen.feature.login.LoginActivity
import de.brlo.hopfen.feature.login.LoginModule

@Module
internal interface ActivityBindingModule {

  @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
  fun loginActivity(): LoginActivity

  @ContributesAndroidInjector(modules = arrayOf(HomeModule::class))
  fun homeActivity(): HomeActivity
}
