package de.brlo.hopfen.feature.firebase

import dagger.Binds
import dagger.Module
import de.brlo.hopfen.feature.Configuration
import de.brlo.hopfen.feature.Reporting
import de.brlo.hopfen.feature.inject.ApplicationScope
import javax.inject.Singleton

@Module(includes = arrayOf(FirebaseConfigurationModule::class))
internal interface FirebaseModule {

  @Binds
  @ApplicationScope
  fun config(firebaseConfig: FirebaseConfiguration): Configuration

  @Binds
  fun reporting(reporting: FirebaseReporting): Reporting
}
