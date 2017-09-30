package de.brlo.hopfen.feature.android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import java.util.Collections

abstract class AbstractAdapter<VH : AbstractAdapter.ViewHolder<T>, T>(val inflater: LayoutInflater) : RecyclerView.Adapter<VH>(), ListAdapter<T> {

  private val items = mutableListOf<T>()

  override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])

  override fun getItemCount() = items.size

  override fun getItem(position: Int) = items[position]

  override fun addItem(item: T) = addItem(0, item)

  override fun addItem(position: Int, item: T) {
    items.add(position, item)
    notifyItemInserted(position)
  }

  override fun addItems(items: Collection<T>) {
    this.items.addAll(items)
    notifyDataSetChanged()
  }

  override fun removeItem(item: T) = removeItem(items.indexOf(item))

  override fun removeItem(position: Int) {
    items.removeAt(position)
    notifyItemRemoved(position)
  }

  fun sort(comparator: Comparator<T>) {
    Collections.sort(items, comparator)
    notifyDataSetChanged()
  }

  abstract class ViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {

     abstract fun bind(t: T)
  }
}
