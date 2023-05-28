package hu.bme.aut.moblab_gamedealr.ui.main

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.ui.games.GamesScreen
import hu.bme.aut.moblab_gamedealr.ui.my_deals.MyDealsScreen

@Composable
fun GamesMainScreen(
    viewModel: MainViewModel,
    navController: NavController,
    selectGame: (Long) -> Unit
) {
    val games: List<Game>  = emptyList()//by viewModel.gameList.collectAsState(initial = listOf())
    val selectedTab = GamedealRHomeTab.getTabFromResource(viewModel.selectedTab.value)
    val tabs = GamedealRHomeTab.values()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.navigationBarsPadding()
            ) {
                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                        label = { Text(text = stringResource(tab.title), color = Color.White) },
                        selected = tab == selectedTab,
                        onClick = { viewModel.selectTab(tab.title) },
                        selectedContentColor = LocalContentColor.current,
                        unselectedContentColor = LocalContentColor.current,
                    )
                }
            }
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(selectedTab,modifier=modifier) { destination ->
            when (destination) {
                GamedealRHomeTab.GAMES -> GamesScreen(hiltViewModel(), navController)
                GamedealRHomeTab.MYDEALS -> MyDealsScreen(modifier, games, hiltViewModel())
            }
        }
    }
}

enum class GamedealRHomeTab(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    GAMES(R.string.menu_games, Icons.Filled.Search),
    MYDEALS(R.string.menu_my_deals, Icons.Filled.List);

    companion object {
        fun getTabFromResource(@StringRes resource: Int): GamedealRHomeTab {
            return when (resource) {
                R.string.menu_my_deals -> MYDEALS
                else -> GAMES
            }
        }
    }
}