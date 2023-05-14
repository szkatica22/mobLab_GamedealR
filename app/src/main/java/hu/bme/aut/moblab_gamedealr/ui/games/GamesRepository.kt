package hu.bme.aut.moblab_gamedealr.ui.games

import android.app.appsearch.SearchResult
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.GamedealRDao
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val gamedealRService: GamedealRService,
//    private val gamedealRDao: GamedealRDao
){
    suspend fun searchGames(query: String): List<Game> {
        return gamedealRService.searchGames(query)
    }
}