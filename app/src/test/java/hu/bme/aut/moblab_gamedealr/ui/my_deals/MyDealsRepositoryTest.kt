package hu.bme.aut.moblab_gamedealr.ui.my_deals

import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import hu.bme.aut.moblab_gamedealr.ui.games.GamesRepository
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any

class MyDealsRepositoryTest {

    @Test
    fun getMyDealsTest() = runBlocking{
        val mockmyDealsDao = Mockito.mock(MyDealsDao::class.java)
        val result =  listOf<MyDeals>()

        Mockito.`when`(mockmyDealsDao.getMyDealsList()).thenReturn(result)

        val myDealsRepository = MyDealsRepository(mockmyDealsDao)
        val myDeals = myDealsRepository.getMyDeals()

        assertEquals(result.size, myDeals.size)
        assertEquals(result, myDeals)
    }

    @Test
    fun deleteMyDealTest() = runBlocking {
        val mockmyDealsDao = Mockito.mock(MyDealsDao::class.java)

        val myDealsRepository = MyDealsRepository(mockmyDealsDao)
        myDealsRepository.deleteDeal(MyDeals("", "", "", "", 0.0, 0.0, false, 0.0))
    }
}