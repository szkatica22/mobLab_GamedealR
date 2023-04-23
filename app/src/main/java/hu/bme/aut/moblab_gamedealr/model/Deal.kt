package hu.bme.aut.moblab_gamedealr.model

import android.media.Image
import java.util.Date

data class Deal (
    val internalName: String,
    val title: String,
    val dealId: String,
//    val storeId: Number,
    val storeName: String, // Todo: Originally we get the store Id but I would like to save the store name here
    val gameId: Number,
    val gameName: String,
    val salePrice: Number,
    val normalPrice: Number,
    val isOnSale: Boolean,
    val savings: Number,
    val releaseDate: Date,
    val lastCange: Date,
    val image: Image
)