package de.brlo.hopfen.feature.home

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import de.brlo.hopfen.feature.R
import de.brlo.hopfen.feature.android.AbstractAdapter
import de.brlo.hopfen.feature.data.Listing
import de.brlo.hopfen.feature.databinding.ItemListingBinding
import javax.inject.Inject

internal class ListingsAdapter @Inject constructor(inflater: LayoutInflater) : AbstractAdapter<ListingsViewHolder, Listing>(inflater) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListingsViewHolder(parent.binding())

  private fun ViewGroup.binding() = DataBindingUtil.inflate<ItemListingBinding>(inflater, R.layout.item_listing, this, false)

  override fun notifyDataSetChanged(old: MutableList<Listing>, new: MutableList<Listing>) = notifyDataSetChanged()
}
