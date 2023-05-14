package hu.bme.aut.moblab_gamedealr.model

import java.util.*

data class Game (
    val gameID: String,
    val steamAppId: String,
    val cheapest: String,
    val cheapestDealID: String,
    val external: String,
    val internalName: String,
    val thumb: String
)