package de.brlo.hopfen.feature.data

data class Listing(
    val uuid: String,
    val hop: Hop,
    val profileUUID: String,
    val locationUUID: String,
    val quantity: Double,
    val quantityUnits: String,
    val price: Double
)
