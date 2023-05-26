package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val initGameList : List<Game> = getInitialGames()

    private val _searchGameNameText = MutableStateFlow("")
    val searchGameNameText = _searchGameNameText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _result= MutableLiveData<List<Game>>()
    val result: LiveData<List<Game>>
        get() = _result

    private val _searchedGames = MutableStateFlow(initGameList)
    val searchedGames = _searchGameNameText
        .debounce(500L)
        .onEach { _isSearching.update { true } }
        .combine(_searchedGames) { text, games ->
            if(text.isBlank()) {
                listOf<Game>()
            } else {
                delay(2000L)
                getSearchedGames()
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _searchedGames.value
        )

    init {
//        getTestGames()
//        getStores()
    }

    fun onSearchedGameNameTextChange(text:String) {
        _searchGameNameText.value = text
    }

    fun getSearchedGames(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _searchedGames.value = (gamesRepository.searchGames(searchGameNameText.value))
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    fun getInitialGames() : List<Game> {
        val initGames: MutableList<Game> = mutableListOf()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                gamesRepository.searchGames("").forEach {game: Game ->
                        initGames += game
                    }
            } catch (e: Exception) {
                println(e)
            }
        }
        return initGames
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