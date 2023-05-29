package hu.bme.aut.moblab_gamedealr.ui.games

import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.Store
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val gamedealRService: GamedealRService,
    private val myDealsDao: MyDealsDao,
){
    suspend fun searchGames(query: String): List<Game> {
        return gamedealRService.searchGames(query)
    }
}