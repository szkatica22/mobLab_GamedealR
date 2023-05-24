package hu.bme.aut.moblab_gamedealr.ui.deals

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple100
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple900
import hu.bme.aut.moblab_gamedealr.ui.theme.White100

@Composable
fun DealsScreen(
    gameId: String,
    viewModel: DealsViewModel,
    navController: NavController,
    pressOnBack: () -> Unit = {}
) {
    // display the game header - name and image;
    // display the list of the deals
    Column() {
        DealsAppBar(gameId, navController)
//        GameHeader(gameId = "testID", viewModel = viewModel) - benan nez ki, kicsi a kep
        DealDetails()
    }

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
                text = "$title - deals",
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

//@Composable
//private fun GameHeader(
//    gameId: String,
//    viewModel: DealsViewModel,
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .padding(horizontal = 10.dp)
//    ) {
//        AsyncImage(
//            model = "https://cdn.cloudflare.steamstatic.com/steam/apps/238010/capsule_sm_120.jpg",
//            contentDescription = "Test image",
//            modifier = Modifier.fillMaxWidth(),
//            contentScale = ContentScale.FillWidth
//        )
//    }
//}

@Composable
private fun DealDetails(
//    deal: Deal,
) {
    // Card with the deal information
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//            .clickable { },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // First row
            Row(
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                // Store name
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(210.dp),
                ) {
                    Text(
                        text = "Store Name",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxWidth(),
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
                // Action in percent
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(70.dp),
                    shape = RoundedCornerShape(12.dp),
                    backgroundColor = Purple100,
                ) {
                    Text(
                        text = "-50%",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = White100
                    )
                }
                // Bookmark Icon
                Image(
                    painterResource(id = R.drawable.ic_add_bookmark),
                    colorFilter = ColorFilter.tint(Color.Black),
                    contentDescription ="Save deal icon",
                    modifier = Modifier.size(40.dp)
                )
            }

            // Divider
            Divider(
                startIndent = 8.dp,
                thickness = 1.5.dp,
                color = Purple900,
                modifier = Modifier.alpha(0.7f)
            )

            // Second row - original price information
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.original_price),
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(end = 10.dp),
                ) {
                    Text(
                        text = "20.00 $",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            // Third row - Actual price information
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.actual_price),
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(end = 10.dp),
                ) {
                    Text(
                        text = "10.00 $",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            // Fourth row - sale ends information
            Row(
                modifier = Modifier.padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.sale_ends),
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(end = 10.dp),
                ) {
                    Text(
                        text = "2023.04.22.",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }

    }
}