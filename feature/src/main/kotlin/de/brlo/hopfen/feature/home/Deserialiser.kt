package de.brlo.hopfen.feature.home

import com.google.firebase.database.DataSnapshot

internal interface Deserialiser<T> {

  fun deserialise(snapshot: DataSnapshot, kls: Class<T>): T
}
