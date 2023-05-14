package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {

    init {
        getTestGames()
        getStores()
    }

    fun getTestGames() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                println(gamesRepository.searchGames("Need"))
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    fun getStores() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                println(gamesRepository.getStores())
            } catch (e: Exception){
                println(e)
            }
        }
    }
}