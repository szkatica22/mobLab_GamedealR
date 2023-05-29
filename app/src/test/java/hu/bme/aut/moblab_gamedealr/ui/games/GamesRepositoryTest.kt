package hu.bme.aut.moblab_gamedealr.ui.games

import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any

class GamesRepositoryTest {
    @Test
    fun searchGamesTest() = runBlocking{
        val mockgamedealRService = Mockito.mock(GamedealRService::class.java)
        val result = listOf<Game>()

        Mockito.`when`(mockgamedealRService.searchGames(any())).thenReturn(result)

        val gamesRepository = GamesRepository(mockgamedealRService)
        val games = gamesRepository.searchGames("Hogwarts Legacy")

        assertEquals(result.size, games.size)
        assertEquals(result, games)
    }
}