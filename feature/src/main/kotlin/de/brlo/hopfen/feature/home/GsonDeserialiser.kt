package de.brlo.hopfen.feature.home

import com.google.firebase.database.DataSnapshot
import com.google.gson.Gson
import javax.inject.Inject

internal class GsonDeserialiser<T> @Inject constructor(private val gson: Gson) : Deserialiser<T> {

  override fun deserialise(snapshot: DataSnapshot, kls: Class<T>): T = gson.fromJson<T>(gson.toJson(snapshot.value), kls)
}
