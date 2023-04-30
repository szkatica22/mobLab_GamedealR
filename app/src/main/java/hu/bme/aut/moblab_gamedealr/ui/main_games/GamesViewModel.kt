package hu.bme.aut.moblab_gamedealr.ui.main_games

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    gamesRepository: GamesRepository
) : ViewModel() {

}