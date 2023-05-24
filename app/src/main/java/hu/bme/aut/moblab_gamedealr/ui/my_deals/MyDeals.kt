package hu.bme.aut.moblab_gamedealr.ui.my_deals

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Game

@Composable
fun MyDealsScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    myDealsViewModel: MyDealsViewModel,
) {
    // list of the saved deals
    MyDealsAppBar()
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
    myDeal: Deal
) {
    // Card with the saved deal information
}