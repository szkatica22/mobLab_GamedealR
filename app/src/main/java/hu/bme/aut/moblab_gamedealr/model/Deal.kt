package hu.bme.aut.moblab_gamedealr.model

import android.media.Image
import java.util.Date

data class Deal (
    val internalName: Long,
    val title: String,
    val dealId: String,
//    val storeId: Number,
    val storeName: String, // Todo: Originally we get the store Id but I would like to save the store name here
    val gameId: Long,
    val gameName: String,
    val salePrice: Double,
    val normalPrice: Double,
    val isOnSale: Boolean,
    val savings: Double,
    val releaseDate: Date,
    val lastChange: Date,
    val image: Image
)