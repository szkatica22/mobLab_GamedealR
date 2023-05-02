package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Game

@Composable
fun GamesScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    selectGame: (Long) -> Unit,
    gamesViewModel: GamesViewModel
) {
    Text(text = "Games screen")
}

@Composable
fun GamesAppBar() {
    TopAppBar(
        elevation = 6.dp,
        backgroundColor = Color.Cyan,
        modifier = Modifier
            .statusBarsPadding()
            .height(58.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun SearchGame() {
    // Search Edit text the top of the screen
}

fun SearchedGameCard(
    searchedGame: Game,
) {
    // Card with the searched result game information
}