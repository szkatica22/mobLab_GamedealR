package hu.bme.aut.moblab_gamedealr.ui.main

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.moblab_gamedealr.ui.games.GamesRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    gamesRepository: GamesRepository
) : ViewModel() {

    private val _selectedTab: MutableState<Int> = mutableStateOf(0)
    val selectedTab: State<Int> get() = _selectedTab

    fun selectTab(@StringRes tab: Int) {
        _selectedTab.value = tab
    }
}