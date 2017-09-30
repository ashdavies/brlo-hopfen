package de.brlo.hopfen.feature.data

enum class ListingType {
    HOPS,
    BARLEY,
    SPENT_GRAIN
}

data class Listing(
        var uuid: String = "",
        var name: String,
        var description: String,
        var listingType: ListingType,
        var quantity: Double,
        var quantityUnits: String,
        var price: Double)
