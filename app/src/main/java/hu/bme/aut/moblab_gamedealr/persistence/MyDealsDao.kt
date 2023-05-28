package hu.bme.aut.moblab_gamedealr.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import hu.bme.aut.moblab_gamedealr.model.MyDeals

@Dao
interface MyDealsDao {

    @Query("SELECT * FROM my_deals")
    suspend fun getMyDealsList(): List<MyDeals>

    @Query("SELECT * FROM my_deals WHERE dealID = :dealIDs")
    suspend fun getOneDeal(dealIDs: String): MyDeals?

    @Insert
    suspend fun saveDeal(vararg savingMyDeal: MyDeals)

    @Delete
    suspend fun deleteMyDeal(myDeal: MyDeals)
}