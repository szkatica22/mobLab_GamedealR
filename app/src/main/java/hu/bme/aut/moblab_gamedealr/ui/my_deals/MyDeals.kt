package hu.bme.aut.moblab_gamedealr.ui.my_deals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.MyDeals
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple100
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple700
import hu.bme.aut.moblab_gamedealr.ui.theme.Purple900
import hu.bme.aut.moblab_gamedealr.ui.theme.White100
import kotlinx.coroutines.launch

@Composable
fun MyDealsScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    viewModel: MyDealsViewModel,
) {
    // get my saved deals
    LaunchedEffect(true){
        viewModel.getMyDeals()
    }
    // list of the saved deals
    Column() {
        MyDealsAppBar()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(viewModel.myDeals) { deal ->
                MyDealDetails(deal, viewModel)
            }
        }
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
    myDeal: MyDeals,
    viewModel: MyDealsViewModel
) {
    // Card with the saved deal information

    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

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
                        contentDescription = "Game photo",
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
                            val saving = myDeal.savings.toInt()
                            var sale: Boolean
                            if(saving > 0) {
                                sale = true
                                Card(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .width(70.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    backgroundColor = Purple100,
                                ) {
                                    Text(
                                        text = "-${myDeal.savings.toDouble().toInt()}%",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        color = White100
                                    )
                                }
                            } else {
                                sale = false
                                Box(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .width(70.dp),
                                )
                            }
                        }
                        // Delete Icon
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    viewModel.deleteDeal(myDeal, context)
                                }
                            },
                            modifier = Modifier.size(48.dp),
                        ) {
                            Icon(painterResource(id = R.drawable.ic_delete), "Delete deal icon")
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
                                text = myDeal.gameName,
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
                        text = myDeal.storeName,
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
                        text = "${myDeal.normalPrice} $",
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
                        text = "${myDeal.salePrice} $",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    )
                }
            }

            // Fourth row - is on sale or not information
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
                    if(myDeal.isOnSale) {
                        Text(
                            text = stringResource(R.string.is_sale),
                            style = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.no_sale),
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