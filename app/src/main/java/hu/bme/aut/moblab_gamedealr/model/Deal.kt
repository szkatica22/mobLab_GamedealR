package hu.bme.aut.moblab_gamedealr.model

import android.media.Image
import java.util.Date

data class Deal (
    val internalName: String,
    val title: String,
    val metacriticLink: String,
    val dealID: String,
    val storeID: String,
    val gameID: String,
    val salePrice: String,
    val normalPrice: String,
    val isOnSale: String,
    val savings: String,
    val metacriticScore: String,
    val steamRatingText: String,
    val steamRatingPercent: String,
    val steamRatingCountval: String,
    val steamAppID: String,
    val releaseDate: Int,
    val lastChange: Int,
    val dealRating: String,
    val thumb: String
)