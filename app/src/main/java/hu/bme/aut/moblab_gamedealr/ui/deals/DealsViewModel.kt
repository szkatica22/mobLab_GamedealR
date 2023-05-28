package hu.bme.aut.moblab_gamedealr.ui.deals

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import hu.bme.aut.moblab_gamedealr.model.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(
    private val dealsRepository: DealsRepository
) : ViewModel() {

    var gameDeals by mutableStateOf<List<Deal>>(listOf())
        private set

    var storesList by mutableStateOf<List<Store>>(listOf())
        private set

    fun getActualDeals(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                gameDeals = dealsRepository.getDeals(title)
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    fun getStores() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                storesList = dealsRepository.getStores()
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    suspend fun saveDeal(deal: Deal, storeName: String, isOnSale: Boolean, context: Context) {
        if(dealsRepository.myDealsDao.getOneDeal(deal.dealID) == null){
            val savingDeal = MyDeals(
                dealID = deal.dealID,
                gameName = deal.title,
                gameID = deal.gameID,
                storeName = storeName,
                salePrice = deal.salePrice.toDouble(),
                normalPrice = deal.normalPrice.toDouble(),
                isOnSale = isOnSale,
                savings = deal.savings.toDouble(),
            )
            dealsRepository.myDealsDao.saveDeal(savingDeal)
            Toast.makeText(context, "Deal saved successfully!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "You already saved this deal!", Toast.LENGTH_SHORT).show()
        }

    }
}