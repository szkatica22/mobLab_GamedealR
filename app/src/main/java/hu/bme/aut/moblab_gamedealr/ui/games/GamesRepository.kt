package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.annotation.WorkerThread
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.Store
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import hu.bme.aut.moblab_gamedealr.persistence.StoreInfoDao
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val gamedealRService: GamedealRService,
    private val myDealsDao: MyDealsDao,
    private val storeInfoDao: StoreInfoDao
//    private val gamedealRDao: GamedealRDao
){
    suspend fun searchGames(query: String): List<Game> {
        return gamedealRService.searchGames(query)
    }
    suspend fun getStores(): List<Store>{
        return gamedealRService.getStores()
    }

    // TODO try out the two dao
}