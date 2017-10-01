package de.brlo.hopfen.feature.data

data class Profile(
    val uuid: String,
    val image: String,
    val name: String,
    val locations: List<Location>
) {

  data class Location(
      val uuid: String,
      val name: String,
      val address: String
  )

  companion object {

    fun empty() = Profile("", "", "", emptyList())
  }
}
