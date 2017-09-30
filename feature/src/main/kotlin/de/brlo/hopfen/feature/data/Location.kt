package de.brlo.hopfen.feature.data

data class Location(
        val uuid: String = "",
        val account: Account,
        val address: String)