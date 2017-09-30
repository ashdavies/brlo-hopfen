package de.brlo.hopfen.feature.data

data class Location(
    val uuid: String,
    val name: String,
    val account: Account,
    val address: String
)
