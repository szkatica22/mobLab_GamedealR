package hu.bme.aut.moblab_gamedealr.model

import java.util.*

data class Game (
    val id: Number,
    val title: String,
    val steamAppId: Number,
    val cheapestPriceValue: Number,
    val cheapestPriceDate: Date,
    val deals: List<Deal>
)