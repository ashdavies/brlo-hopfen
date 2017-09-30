package de.brlo.hopfen.feature.home

import android.support.v7.util.DiffUtil
import de.brlo.hopfen.feature.data.Listing

internal class ListingsDiffUtilCallback(private val oldItems: MutableList<Listing>, private val newItems: MutableList<Listing>) : DiffUtil.Callback() {

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldItems[oldItemPosition] == newItems[newItemPosition]

  override fun getOldListSize() = oldItems.size

  override fun getNewListSize() = newItems.size

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = oldItems[oldItemPosition] == newItems[newItemPosition]
}
