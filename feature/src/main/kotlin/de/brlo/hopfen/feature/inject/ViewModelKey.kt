package de.brlo.hopfen.feature.inject

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.KClass

@MapKey
@Retention(RUNTIME)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)
