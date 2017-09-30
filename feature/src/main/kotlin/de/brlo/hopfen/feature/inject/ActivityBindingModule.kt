package de.brlo.hopfen.feature.inject

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.brlo.hopfen.feature.home.HomeActivity
import de.brlo.hopfen.feature.home.HomeModule
import de.brlo.hopfen.feature.login.LoginActivity
import de.brlo.hopfen.feature.login.LoginModule
import de.brlo.hopfen.feature.settings.SettingsActivity
import de.brlo.hopfen.feature.settings.SettingsModule

@Module
internal interface ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = arrayOf(HomeModule::class))
  fun homeActivity(): HomeActivity

  @ActivityScope
  @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
  fun loginActivity(): LoginActivity

  @ActivityScope
  @ContributesAndroidInjector(modules = arrayOf(SettingsModule::class))
  fun preferenceActivity(): SettingsActivity
}
