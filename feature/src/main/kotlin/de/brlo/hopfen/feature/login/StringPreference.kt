package de.brlo.hopfen.feature.login

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal class StringPreference(private val preferences: SharedPreferences, private val name: String, private val default: String) : ReadWriteProperty<Any, String> {

  override fun getValue(thisRef: Any, property: KProperty<*>) = preferences.getString(name, default)!!

  override fun setValue(thisRef: Any, property: KProperty<*>, value: String) = preferences.edit().putString(name, value).apply()
}
