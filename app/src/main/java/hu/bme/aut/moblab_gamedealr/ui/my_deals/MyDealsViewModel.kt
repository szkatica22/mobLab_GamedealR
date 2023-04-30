package hu.bme.aut.moblab_gamedealr.ui.my_deals

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyDealsViewModel @Inject constructor(
    private val myDealsRepository: MyDealsRepository
) : ViewModel() {
}