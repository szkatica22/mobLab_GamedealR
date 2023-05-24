package hu.bme.aut.moblab_gamedealr.ui.my_deals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple100
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple700
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple900
import hu.bme.aut.moblab_gamedealr.ui.theme.White100

@Composable
fun MyDealsScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    myDealsViewModel: MyDealsViewModel,
) {
    // list of the saved deals
    Column() {
        MyDealsAppBar()
        MyDealDetails()
    }
}

@Composable
fun MyDealsAppBar() {
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
            text = stringResource(R.string.menu_my_deals),
            color = Color.White,
            fontSize = 18.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun MyDealDetails(
//    myDeal: Deal
) {
    // Card with the saved deal information

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
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier =  Modifier
                            .fillMaxWidth()
                    ) {
                        // Action in percent
                        Box(
                            contentAlignment = Alignment.BottomStart,
                            modifier = Modifier
//                                .width(100.dp)
                                .padding(start = 16.dp),
                        ) {
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
                        }
                        // Delete Icon
                        Box(
                            contentAlignment = Alignment.BottomEnd,
                            modifier = Modifier
//                                .width(50.dp)
                                .padding(end = 10.dp),
                        ) {
                            Image(
                                painterResource(id = R.drawable.ic_delete),
                                colorFilter = ColorFilter.tint(Color.Black),
                                contentDescription ="Delete saved deal icon",
                                modifier = Modifier.size(42.dp)
                            )
                        }
                    }
                    // Game name
                    Row(
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .width(240.dp),
                        ) {
                            Text(
                                text = "Game Name",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 28.sp
                                )
                            )
                        }
                    }
                }
            }

            // Divider I.
            Divider(
                startIndent = 8.dp,
                thickness = 1.5.dp,
                color = Purple700,
                modifier = Modifier.alpha(0.7f)
            )

            // Store name
            Row(
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    contentAlignment = Alignment.BottomStart,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(start = 10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.store),
                        style = TextStyle(
                            color = Purple900,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
                Box(
                    contentAlignment = Alignment.BottomEnd,
                    modifier = Modifier
                        .width(320.dp)
                        .padding(end = 10.dp),
                ) {
                    Text(
                        text = "Epic games",
                        style = TextStyle(
                            color = Purple900,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    )
                }
            }

            // Divider II.
            Divider(
                startIndent = 8.dp,
                thickness = 1.5.dp,
                color = Purple700,
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