package de.brlo.hopfen.feature.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

abstract class ActivityCompanion<out IntentOptions>(val options: IntentOptions, val kls: KClass<out Activity>) {

  inline fun start(context: Context, configure: IntentOptions.(Intent) -> Unit) {
    context.startActivity(Intent(context, kls.java).apply { configure(options, this) })
  }

  inline fun startForResult(activity: Activity, code: Int, configure: IntentOptions.(Intent) -> Unit) {
    activity.startActivityForResult(Intent(activity, kls.java).apply { configure(options, this) }, code)
  }

  inline fun <T> Intent.options(block: IntentOptions.(Intent) -> T): T = block(options, this)
}
