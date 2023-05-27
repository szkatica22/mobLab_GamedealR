package hu.bme.aut.moblab_gamedealr.ui.deals

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.ui.games.SearchedGameCard
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple100
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple900
import hu.bme.aut.moblab_gamedealr.ui.theme.White100
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun DealsScreen(
    gameName: String,
    viewModel: DealsViewModel,
    navController: NavController,
    pressOnBack: () -> Unit = {}
) {

    // get deals for the actual game
    LaunchedEffect(gameName) {
        viewModel.getActualDeals(gameName)
    }

    // Save store information once
    LaunchedEffect(true) {
        viewModel.getStores()
    }

    // display the game header - name and image;
    // display the list of the deals
    Column() {
        DealsAppBar(gameName, navController)
        GameHeader() // - benan nez ki, kicsi a kep, ugyhogy random kep van
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(viewModel.gameDeals) { deal ->
                DealDetails(deal, viewModel)
            }
        }

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
                text = title,
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
}

@Composable
private fun GameHeader(
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(2.dp)
    ) {
        AsyncImage(
            model = "https://picsum.photos/300/200",
            contentDescription = "Header image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
private fun DealDetails(
    deal: Deal,
    viewModel: DealsViewModel
) {
    // Card with the deal information
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
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
                        text = viewModel.storesList.first{it.storeID == deal.storeID}.storeName,
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
                val saving = deal.savings.toDouble().toInt()
                if(saving > 0) {
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(70.dp),
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = Purple100,
                    ) {
                        Text(
                            text = "-${deal.savings.toDouble().toInt()}%",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = White100
                        )
                    }
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
                        text = "${deal.normalPrice} $",
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
                        text = "${deal.salePrice} $",
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
                        text = stringResource(R.string.is_on_sale),
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
                    if(deal.isOnSale == "0") {
                        Text(
                            text = stringResource(R.string.no_sale),
                            style = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.is_sale),
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
}