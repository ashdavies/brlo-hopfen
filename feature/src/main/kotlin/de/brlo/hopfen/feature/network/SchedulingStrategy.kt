package de.brlo.hopfen.feature.network

import io.reactivex.FlowableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer

class SchedulingStrategy(private val subscriber: Scheduler, private val observer: Scheduler) {

  fun <T> single() = SingleTransformer<T, T> { upstream ->
    upstream
        .subscribeOn(subscriber)
        .observeOn(observer)
  }

  fun <T> maybe() = MaybeTransformer<T, T> { upstream ->
    upstream
        .subscribeOn(subscriber)
        .observeOn(observer)
  }

  fun <T> observable() = ObservableTransformer<T, T> { upstream ->
    upstream
        .subscribeOn(subscriber)
        .observeOn(observer)
  }

  fun <T> flowable() = FlowableTransformer<T, T> { upstream ->
    upstream
        .subscribeOn(subscriber)
        .observeOn(observer)
  }
}
