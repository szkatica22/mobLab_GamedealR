package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.moblab_gamedealr.model.Game
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class GamesViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {

    var searchGameNameText by mutableStateOf("")
        private set

    var searchedGames by mutableStateOf<List<Game>>(listOf())
        private set

    init {
        CheckAndSaveStores()
    }

    fun onSearchedGameNameTextChange(text:String) {
        searchGameNameText = text
    }

    fun getSearchedGames() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                searchedGames = gamesRepository.searchGames(searchGameNameText)
            } catch (e: Exception) {
                println(e)
            }
        }
    }


    fun CheckAndSaveStores() {
//        viewModelScope.launch(Dispatchers.IO){
//            try {
//                println(gamesRepository.getStores())
//            } catch (e: Exception){
//                println(e)
//            }
//        }
    }
}