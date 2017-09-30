package de.brlo.hopfen.feature.extensions

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup

fun <T : ViewDataBinding> Fragment.getDataBinding(inflater: LayoutInflater, @LayoutRes resId: Int, container: ViewGroup?): T {
  return DataBindingUtil.inflate(inflater, resId, container, false)
}

inline fun <reified T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory = ViewModelProviders.DefaultFactory(activity.application)): T {
  return ViewModelProviders.of(this, factory).get(T::class.java)
}
