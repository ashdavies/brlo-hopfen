package de.brlo.hopfen.feature.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity

fun <T : ViewDataBinding> FragmentActivity.getDataBinding(@LayoutRes resId: Int): T {
  return DataBindingUtil.setContentView(this, resId)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(application)): T {
  return ViewModelProviders.of(this, factory).get(T::class.java)
}
