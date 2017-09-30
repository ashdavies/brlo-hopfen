package de.brlo.hopfen.feature.home

import android.view.View
import de.brlo.hopfen.feature.android.AbstractAdapter
import de.brlo.hopfen.feature.data.Listing

internal class ListingsViewHolder(view: View) : AbstractAdapter.ViewHolder<Listing>(view) {

  override fun bind(t: Listing) = Unit
}
