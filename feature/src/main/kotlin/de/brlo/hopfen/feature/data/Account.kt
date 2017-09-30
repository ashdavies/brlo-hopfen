package de.brlo.hopfen.feature.data

data class Account(
        var uuid: String = "",
        var token: String,
        val brewery: Boolean)
