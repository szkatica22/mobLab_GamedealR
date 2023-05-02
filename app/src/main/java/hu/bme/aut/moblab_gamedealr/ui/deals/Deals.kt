package hu.bme.aut.moblab_gamedealr.ui.deals

import androidx.compose.runtime.Composable
import hu.bme.aut.moblab_gamedealr.model.Deal

@Composable
fun DealsScreen(
    gameId: Long,
    viewModel: DealsViewModel,
    pressOnBack: () -> Unit = {}
) {
    // display the game header - name and image;
    // display the list of the deals
}

@Composable
private fun GameHeader(
    gameId: Long,
    viewModel: DealsViewModel,
) {

}

@Composable
private fun DealDetails(
    deal: Deal,
) {
    // Card with the deal information
}