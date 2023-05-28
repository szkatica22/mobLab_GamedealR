package hu.bme.aut.moblab_gamedealr.ui.my_deals

import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import javax.inject.Inject

class MyDealsRepository @Inject constructor(
    private val myDealsDao: MyDealsDao,
) {

    suspend fun getMyDeals(): List<MyDeals> {
        return myDealsDao.getMyDealsList()
    }

    suspend fun deleteDeal(deal: MyDeals) {
        myDealsDao.deleteMyDeal(deal)
    }
}