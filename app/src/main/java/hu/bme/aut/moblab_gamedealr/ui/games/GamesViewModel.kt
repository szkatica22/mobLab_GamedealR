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
    }

    fun getTestGames() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                println(gamesRepository.searchGames("Overcooked"))
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}