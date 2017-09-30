package de.brlo.hopfen.feature.home

import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.android.AbstractAdapter
import de.brlo.hopfen.feature.data.Listing
import javax.inject.Inject

internal class ListingsAdapter @Inject constructor(inflater: LayoutInflater) : AbstractAdapter<ListingsViewHolder, Listing>(inflater) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListingsViewHolder(inflate(parent))

  private fun inflate(parent: ViewGroup) = inflater.inflate(R.layout.item_listing, parent, false)

  override fun notifyDataSetChanged(old: MutableList<Listing>, new: MutableList<Listing>) {
    notifyDataSetChanged()
//    DiffUtil.calculateDiff(ListingsDiffUtilCallback(old, new)).dispatchUpdatesTo(this)
  }
}
