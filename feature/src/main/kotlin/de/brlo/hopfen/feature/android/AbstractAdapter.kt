package de.brlo.hopfen.feature.android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import kotlin.properties.Delegates

abstract class AbstractAdapter<VH : AbstractAdapter.ViewHolder<T>, T>(val inflater: LayoutInflater) : RecyclerView.Adapter<VH>() {

  var items by Delegates.observable(mutableListOf<T>(), { _, old, new -> notifyDataSetChanged(old, new) })

  override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])

  override fun getItemCount() = items.size

  abstract fun notifyDataSetChanged(old: MutableList<T>, new: MutableList<T>)

  abstract class ViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(t: T)
  }
}
