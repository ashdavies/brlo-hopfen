package de.brlo.hopfen.feature.home

import android.app.AlertDialog
import de.brlo.hopfen.feature.R
import javax.inject.Inject

internal class HomeNavigation @Inject constructor(private val navigator: Navigator) {

  fun showListingsError() {
    navigator.navigate {
      AlertDialog.Builder(it)
          .setTitle(R.string.error_dialog_title)
          .setMessage(R.string.error_listings_failed)
          .show()
    }
  }
}