package de.brlo.hopfen.feature

interface Configuration {

  fun isEnabled(name: String): Boolean
}
