package hu.bme.aut.moblab_gamedealr.ui.deals

import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Store
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import javax.inject.Inject

class DealsRepository @Inject constructor(
    private val gamedealRService: GamedealRService,
    val myDealsDao: MyDealsDao
){

    suspend fun getDeals(query: String): List<Deal> {
        return gamedealRService.getDeals(query)
    }

    suspend fun getStores(): List<Store>{
        return gamedealRService.getStores()
    }
}