package de.brlo.hopfen.feature.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

internal class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(kls: Class<T>): T {
    var creator: Provider<out ViewModel>? = creators[kls]

    creator ?: creators.keys.firstOrNull(kls::isAssignableFrom)?.apply { creator = creators[this] }
    creator ?: throw IllegalArgumentException("Unrecognised class " + kls)

    return creator?.get() as T
  }
}
