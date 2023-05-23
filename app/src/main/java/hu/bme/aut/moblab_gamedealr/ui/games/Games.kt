package hu.bme.aut.moblab_gamedealr.ui.games

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Game

@Composable
fun GamesScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    selectGame: (Long) -> Unit,
    gamesViewModel: GamesViewModel
) {
    Column {
        Text(text = "Games screen")
        SearchedGameCard("Test gamename")
    }
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

@Composable
fun SearchedGameCard(
//    searchedGame: Game,
    testName: String
) {
    // Card with the searched result game information
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = rememberAsyncImagePainter("https://example.com/image.jpg"),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column(
                modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = testName,
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Button(
//                    modifier = Modifier.height(60.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                    shape = RoundedCornerShape(20.dp),
                    onClick = {
                        println("TODO BUTTON - GO TO THE DEALS")
                    }
                ) {
//                    Image(
//                        painterResource(id = R.drawable.ic_deal),
//                        colorFilter = ColorFilter.tint(Color.White),
//                        contentDescription ="Deals button icon",
//                        modifier = Modifier.size(20.dp)
//                    )
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = "See deals",
//                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
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