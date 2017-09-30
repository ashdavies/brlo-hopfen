package de.brlo.hopfen.feature.home

import android.view.View
import de.brlo.hopfen.feature.android.AbstractAdapter
import de.brlo.hopfen.feature.android.ViewModel
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.databinding.ItemListingBinding

internal class ListingsViewHolder(view: View) : AbstractAdapter.ViewHolder<Listing>(view) {

  private lateinit var binding: ItemListingBinding

  override fun bind(t: Listing) = Unit

  class ListingViewModel : ViewModel<Listing>()
}
