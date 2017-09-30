package de.brlo.hopfen.feature

import android.os.Bundle

interface Reporting {

  fun event(name: String)

  fun event(name: String, bundle: Bundle)
}
