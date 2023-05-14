package hu.bme.aut.moblab_gamedealr.ui.deals

import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.GamedealRDao
import javax.inject.Inject

class DealsRepository @Inject constructor(
    private val gamedealRService: GamedealRService
//    private val gamedealRDao: GamedealRDao
){

    suspend fun getDeals(query: String): List<Deal> {
        return gamedealRService.getDeals(query)
    }
}