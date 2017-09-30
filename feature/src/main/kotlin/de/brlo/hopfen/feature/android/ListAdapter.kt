package de.brlo.hopfen.feature.android

internal interface ListAdapter<T> {

  fun getItem(position: Int): T

  fun addItem(item: T)

  fun addItem(position: Int, item: T)

  fun addItems(items: Collection<T>)

  fun removeItem(item: T)

  fun removeItem(position: Int)
}
