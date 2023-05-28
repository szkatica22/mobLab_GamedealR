package hu.bme.aut.moblab_gamedealr.ui.my_deals

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import javax.inject.Inject

@HiltViewModel
class MyDealsViewModel @Inject constructor(
    private val myDealsRepository: MyDealsRepository
) : ViewModel() {

    var myDeals by mutableStateOf<List<MyDeals>>(listOf())
        private set
    suspend fun getMyDeals() {
        myDeals = myDealsRepository.getMyDeals()
    }

    suspend fun deleteDeal(deal: MyDeals, context: Context) {
        myDealsRepository.deleteDeal(deal)
        Toast.makeText(context, "Deal deleted successfully!", Toast.LENGTH_SHORT).show()
        getMyDeals()
    }
}