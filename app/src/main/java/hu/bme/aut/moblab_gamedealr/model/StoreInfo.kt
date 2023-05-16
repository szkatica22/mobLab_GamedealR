package hu.bme.aut.moblab_gamedealr.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stores")
data class StoreInfo (
    @PrimaryKey @ColumnInfo(name = "storeID") val storeID: String,
    @ColumnInfo(name = "store_name") val storeName: String,
    @ColumnInfo(name = "is_active") val isActive: Boolean,
)