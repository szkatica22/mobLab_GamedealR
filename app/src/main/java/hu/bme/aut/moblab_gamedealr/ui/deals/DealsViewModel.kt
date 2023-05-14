package hu.bme.aut.moblab_gamedealr.ui.deals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(
    private val dealsRepository: DealsRepository
) : ViewModel() {

    init {
        getTestDeals()
    }

    fun getTestDeals() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                println(dealsRepository.getDeals("Overcooked"))
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}