package hu.bme.aut.moblab_gamedealr.model

import java.util.*

data class Game (
    val id: Long,
    val title: String,
    val steamAppId: Long,
    val cheapestPriceValue: Double,
    val cheapestPriceDate: Date,
    val deals: List<Deal>
)