package hu.bme.aut.moblab_gamedealr.ui.deals

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.moblab_gamedealr.model.Deal
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
}