package hu.bme.aut.moblab_gamedealr.ui.my_deals

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Game

@Composable
fun MyDealsScreen(
    modifier: Modifier = Modifier,
    games: List<Game>,
    myDealsViewModel: MyDealsViewModel,
) {
    // list of the saved deals
    Text(text = "My deals screen")
}

@Composable
fun MyDealDetails(
    myDeal: Deal
) {
    // Card with the saved deal information
}