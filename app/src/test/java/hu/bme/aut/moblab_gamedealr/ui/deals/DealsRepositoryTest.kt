package hu.bme.aut.moblab_gamedealr.ui.deals

import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Store
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any

class DealsRepositoryTest {

    @Test
    fun getDealsTest() = runBlocking {
        val mockgamedealRService = Mockito.mock(GamedealRService::class.java)
        val mockmyDealsDao = Mockito.mock(MyDealsDao::class.java)
        val result = listOf<Deal>()

        Mockito.`when`(mockgamedealRService.getDeals(any())).thenReturn(result)

        val dealsRepository = DealsRepository(mockgamedealRService, mockmyDealsDao)
        val deals = dealsRepository.getDeals("Overcooked")

        assertEquals(result.size, deals.size)
        assertEquals(result, deals)
    }

    @Test
    fun getStoresTest() = runBlocking {
        val mockgamedealRService = Mockito.mock(GamedealRService::class.java)
        val mockmyDealsDao = Mockito.mock(MyDealsDao::class.java)
        val result = listOf<Store>()

        Mockito.`when`(mockgamedealRService.getStores()).thenReturn(result)

        val dealsRepository = DealsRepository(mockgamedealRService, mockmyDealsDao)
        val stores = dealsRepository.getStores()

        assertEquals(result.size, stores.size)
        assertEquals(result, stores)
    }
}