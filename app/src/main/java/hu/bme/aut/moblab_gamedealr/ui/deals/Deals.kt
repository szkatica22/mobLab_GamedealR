package hu.bme.aut.moblab_gamedealr.ui.deals

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hu.bme.aut.moblab_gamedealr.model.Deal

@Composable
fun DealsScreen(
    gameId: String,
    viewModel: DealsViewModel,
    navController: NavController,
    pressOnBack: () -> Unit = {}
) {
    // display the game header - name and image;
    // display the list of the deals
    DealsAppBar(gameId, navController)
}

@Composable
fun DealsAppBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
//                    .align(Alignment.Center),
                text = "$title deals",
                color = Color.White,
                fontSize = 18.sp,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
//    TopAppBar(
//        elevation = 6.dp,
//        modifier = Modifier
//            .statusBarsPadding()
//            .height(58.dp)
//            .fillMaxWidth()
//    ) {
//        Text(
//            modifier = Modifier
//                .padding(8.dp)
//                .fillMaxWidth()
//                .align(Alignment.CenterVertically),
//            text = "$title deals",
//            color = Color.White,
//            fontSize = 18.sp,
//            maxLines = 1,
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold
//        )
//    }
}

@Composable
private fun GameHeader(
    gameId: String,
    viewModel: DealsViewModel,
) {

}

@Composable
private fun DealDetails(
    deal: Deal,
) {
    // Card with the deal information
}