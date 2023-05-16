package hu.bme.aut.moblab_gamedealr.persistence

import androidx.room.*
import hu.bme.aut.moblab_gamedealr.model.StoreInfo

@Dao
interface StoreInfoDao {

    @Query("SELECT * FROM stores")
    suspend fun getStoresList(): List<StoreInfo>

    @Query("SELECT * FROM stores WHERE storeID = :storeID")
    suspend fun getStore(storeID: String): StoreInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStores(vararg stores: StoreInfo)

    @Delete
    suspend fun deleteStore(storeInfo: StoreInfo)
}