package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.ui.main.NavScreen
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple900

@Composable
fun GamesScreen(
    gamesViewModel: GamesViewModel,
    navController: NavController
) {
    Column {
        GamesAppBar()
        SearchGame(gamesViewModel, navController)
    }
}

@Composable
fun GamesAppBar() {
    TopAppBar(
        elevation = 6.dp,
        modifier = Modifier
            .statusBarsPadding()
            .height(58.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            text = stringResource(R.string.menu_games),
            color = Color.White,
            fontSize = 18.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun SearchGame(viewModel: GamesViewModel, navController: NavController) {

    // Search Edit text the top of the screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val focusManager = LocalFocusManager.current

        TextField(
            value = viewModel.searchGameNameText,
            onValueChange = viewModel::onSearchedGameNameTextChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                viewModel.getSearchedGames()
                focusManager.clearFocus()
            }),
            placeholder = { Text(text = "Searched game name...") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(viewModel.searchedGames) { game ->
                SearchedGameCard(searchedGame = game, navController = navController)
            }
        }
    }
}

@Composable
fun SearchedGameCard(
    searchedGame: Game,
    navController: NavController
) {
    // Card with the searched result game information
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                AsyncImage(
                    model = "https://picsum.photos/400",
                    contentDescription = "Test image",
                )
            }
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = searchedGame.external,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Purple900),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        navController.navigate(route = "${NavScreen.GamedealDetails.route}/${searchedGame.external}")
                    }
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "See deals",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Image(
                        painterResource(id = R.drawable.ic_arrow),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentDescription ="Deals button icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
        
    }
}