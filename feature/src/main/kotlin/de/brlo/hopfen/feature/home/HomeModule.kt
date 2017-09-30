package de.brlo.hopfen.feature.home

@Module(includes = arrayOf(
    GalleryModule::class,
    HomeViewModelModule::class,
    MatchModule::class,
    SearchModule::class
))
internal class HomeModule {

  @Provides
  fun activity(activity: HomeActivity): FragmentActivity = activity

  @Provides
  fun user() = FirebaseAuth.getInstance().currentUser

  @Provides
  fun reference(user: FirebaseUser) = FirebaseDatabase.getInstance().getReference(user.uid)
}
