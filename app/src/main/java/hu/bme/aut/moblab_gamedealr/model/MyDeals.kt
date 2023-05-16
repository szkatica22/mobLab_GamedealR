package hu.bme.aut.moblab_gamedealr.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "my_deals")
data class MyDeals(
    @PrimaryKey val dealID: Int,
    @ColumnInfo(name = "game_name") val gameName: String,
    @ColumnInfo(name = "game_id") val gameID: String,
    @ColumnInfo(name = "store_name") val storeName: String,
    @ColumnInfo(name = "sale_price") val salePrice: Double,
    @ColumnInfo(name = "normal_price") val normalPrice: Double,
    @ColumnInfo(name = "is_on_sale") val isOnSale: Boolean,
    @ColumnInfo(name = "savings") val savings: Double,
    @ColumnInfo(name = "release_date") val releaseDate: Int,
    @ColumnInfo(name = "last_change") val lastChange: Int,
)