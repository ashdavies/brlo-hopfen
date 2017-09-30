package de.brlo.hopfen.feature.data

data class Listing(
    val uuid: String,
    val hop: Hop,
    val profile: Profile,
    val location: Profile.Location,
    val quantity: Double,
    val quantityUnits: String,
    val price: Double
)
