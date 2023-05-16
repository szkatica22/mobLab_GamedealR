package hu.bme.aut.moblab_gamedealr.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import hu.bme.aut.moblab_gamedealr.model.StoreInfo

@Database(entities = [MyDeals::class, StoreInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun myDealsDao(): MyDealsDao
    abstract fun storeInfoDao(): StoreInfoDao
}