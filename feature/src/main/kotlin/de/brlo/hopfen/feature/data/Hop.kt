package de.brlo.hopfen.feature.data

data class Hop(
    val uuid: String,
    val name: String,
    val country: String,
    val alpha: String) {

  override fun toString(): String {
    return name
  }

  companion object {

    fun empty() = Hop("", "", "", "")
  }
}
