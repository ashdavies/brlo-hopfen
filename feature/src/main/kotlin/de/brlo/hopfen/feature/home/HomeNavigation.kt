package de.brlo.hopfen.feature.home

import android.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.Spinner
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.data.Hop
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

  fun showProfileError() {
    navigator.navigate {
      AlertDialog.Builder(it)
          .setTitle(R.string.error_dialog_title)
          .setMessage(R.string.error_profile_failed)
          .show()
    }
  }

  fun showHopsError() {
    navigator.navigate {
      AlertDialog.Builder(it)
          .setTitle(R.string.error_dialog_title)
          .setMessage(R.string.error_hops_failed)
          .show()
    }
  }

  fun showAddListingDialog(hops: List<Hop>) {
    navigator.navigate {
      val view = it.layoutInflater.inflate(R.layout.dialog_edit_listing, null)

      val spinner = view.findViewById<Spinner>(R.id.hopsStyleSpinner)
      spinner.adapter = ArrayAdapter<Hop>(spinner.context, android.R.layout.simple_spinner_item, hops)

      AlertDialog.Builder(it)
          .setView(view)
          .setPositiveButton(R.string.add_listing, { _, _ ->

          })
          .setNegativeButton(R.string.cancel, null)
          .setTitle(R.string.new_listing_dialog_title)
          .show()
    }
  }
}
