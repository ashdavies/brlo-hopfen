package de.brlo.hopfen.feature.data

data class Listing(
    val uuid: String,
    val hop: Hop,
    val location: Location,
    val quantity: Double,
    val quantityUnits: String,
    val price: Double
)
