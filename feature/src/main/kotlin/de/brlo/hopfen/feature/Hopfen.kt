package de.brlo.hopfen.feature

import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import de.brlo.hopfen.feature.inject.DaggerApplicationComponent

class Hopfen : DaggerApplication() {

  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.builder()
        .application(this)
        .build()
  }
}
