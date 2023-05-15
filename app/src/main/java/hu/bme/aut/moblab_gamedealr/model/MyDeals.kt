package hu.bme.aut.moblab_gamedealr.model

import java.util.*

data class MyDeals(
    val gameName: String,
    val storeName: String,
    val gameID: String,
    val salePrice: Double,
    val normalPrice: Double,
    val isOnSale: Boolean,
    val savings: Double,
    val releaseDate: Date,
    val lastChange: Date,
)