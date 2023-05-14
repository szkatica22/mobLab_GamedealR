package hu.bme.aut.moblab_gamedealr.model

import java.util.*

data class Game (
    val gameID: String,
    val title: String,
    val steamAppId: Long,
    val cheapestPriceValue: Double,
    val cheapestPriceDate: Date,
    val deals: List<Deal>
)