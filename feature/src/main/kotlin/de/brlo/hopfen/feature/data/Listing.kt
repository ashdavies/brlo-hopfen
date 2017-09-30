package de.brlo.hopfen.feature.data

data class Listing(
        val uuid: String = "",
        val name: String,
        val description: String,
        val listingType: Type,
        val quantity: Double,
        val quantityUnits: String,
        val price: Double) {

    enum class Type {
        HOPS,
        BARLEY,
        SPENT_GRAIN
    }

}
