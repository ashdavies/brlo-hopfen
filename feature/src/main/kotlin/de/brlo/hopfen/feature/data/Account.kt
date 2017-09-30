package de.brlo.hopfen.feature.data

data class Account(
        var uuid: String = "",
        val token: String = "",
        val brewery: Boolean = false)
