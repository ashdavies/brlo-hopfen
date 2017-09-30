package de.brlo.hopfen.feature.data

enum class ListingType {
    HOPS,
    BARLEY,
    SPENT_GRAIN
}

data class Listing(
        val uuid: String = "",
        val name: String,
        val description: String,
        val listingType: ListingType,
        val quantity: Double,
        val quantityUnits: String,
        val price: Double)
