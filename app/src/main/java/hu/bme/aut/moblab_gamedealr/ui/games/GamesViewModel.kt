package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {
}