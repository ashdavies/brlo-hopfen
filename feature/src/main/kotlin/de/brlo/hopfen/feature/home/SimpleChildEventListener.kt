package de.brlo.hopfen.feature.home

import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

internal abstract class SimpleChildEventListener : ChildEventListener {

  override fun onCancelled(error: DatabaseError?) = Unit

  override fun onChildMoved(p0: DataSnapshot?, p1: String?) = Unit

  override fun onChildChanged(p0: DataSnapshot?, p1: String?) = Unit

  override fun onChildAdded(p0: DataSnapshot?, p1: String?) = Unit

  override fun onChildRemoved(p0: DataSnapshot?) = Unit
}
