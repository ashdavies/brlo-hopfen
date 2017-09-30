package de.brlo.hopfen.feature.home

import android.view.View
import de.brlo.hopfen.feature.android.AbstractAdapter
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.databinding.ItemListingBinding

internal class ListingsViewHolder private constructor(private val binding: ItemListingBinding, view: View) : AbstractAdapter.ViewHolder<Listing>(view) {

  constructor(binding: ItemListingBinding) : this(binding, binding.root)

  override fun bind(t: Listing) {
    binding.listing = t
  }
}
