package de.brlo.hopfen.feature.home

import android.app.AlertDialog
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.data.Hop
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.data.Profile
import java.util.*
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

  fun showAddListingDialog(hops: List<Hop>, profile: Profile, callback: (Listing) -> Unit) {
    navigator.navigate {
      val editView = it.layoutInflater.inflate(R.layout.dialog_edit_listing, null)

      val hopSpinner = editView.findViewById<Spinner>(R.id.hopsStyleSpinner)
      hopSpinner.adapter = ArrayAdapter<Hop>(hopSpinner.context, android.R.layout.simple_spinner_item, hops)

      val locationSpinner = editView.findViewById<Spinner>(R.id.locationSpinner)
      locationSpinner.adapter = ArrayAdapter<Profile.Location>(locationSpinner.context, android.R.layout.simple_spinner_item, profile.locations)

      AlertDialog.Builder(it)
          .setView(editView)
          .setPositiveButton(R.string.add_listing, { _, _ ->
            val quantity = editView.findViewById<EditText>(R.id.quantityEditText).text.toString().toDouble()
            val quantityUnits = editView.findViewById<Spinner>(R.id.quantityUnitSpinner).selectedItem.toString()
            val price = editView.findViewById<EditText>(R.id.priceEditText).text.toString().toDouble()
            val hop = hopSpinner.selectedItem as Hop
            val location = locationSpinner.selectedItem as Profile.Location

            val listing = Listing(UUID.randomUUID().toString(), hop, profile, location, quantity, quantityUnits, price)

            callback.invoke(listing)
          })
          .setNegativeButton(R.string.cancel, null)
          .setTitle(R.string.new_listing_dialog_title)
          .show()
    }
  }
}
