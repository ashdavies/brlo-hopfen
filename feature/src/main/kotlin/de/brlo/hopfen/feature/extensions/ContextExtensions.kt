package de.brlo.hopfen.feature.extensions

import android.content.Context
import android.support.annotation.FontRes
import android.support.v4.content.res.ResourcesCompat

internal fun Context.getFont(@FontRes idRes: Int) = ResourcesCompat.getFont(this, idRes)
