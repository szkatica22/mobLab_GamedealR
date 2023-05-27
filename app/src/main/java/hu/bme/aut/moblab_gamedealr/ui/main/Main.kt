package hu.bme.aut.moblab_gamedealr.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hu.bme.aut.moblab_gamedealr.ui.deals.DealsScreen

@Composable
fun GamedealRMainScreen() {
    val navController = rememberNavController()

    val colors = MaterialTheme.colors

    var statusBarColor by remember { mutableStateOf(colors.primaryVariant) }
    var navigationBarColor by remember { mutableStateOf(colors.primaryVariant) }

    NavHost(navController = navController, startDestination = NavScreen.Home.route) {
        composable(NavScreen.Home.route) {
            GamesMainScreen(
                viewModel = hiltViewModel(),
                navController = navController,
                selectGame = {
                    navController.navigate("${NavScreen.GamedealDetails.route}/$it")
                }
            )

            LaunchedEffect(Unit) {
                statusBarColor = colors.primaryVariant
                navigationBarColor = colors.primaryVariant
            }
        }
        composable(
            route = NavScreen.GamedealDetails.routeWithArgument,
            arguments = listOf(
                navArgument(NavScreen.GamedealDetails.argument0) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val gameName =
                backStackEntry.arguments?.getString(NavScreen.GamedealDetails.argument0) ?: return@composable

            DealsScreen(gameName = gameName, viewModel = hiltViewModel(), navController = navController) {
                navController.navigateUp()
            }

            LaunchedEffect(Unit) {
                statusBarColor = Color.Transparent
                navigationBarColor = colors.background
            }
        }
    }
}

sealed class NavScreen(val route: String) {

    object Home : NavScreen("Home")

    object GamedealDetails : NavScreen("GamedealDetails") {

        const val routeWithArgument: String = "GamedealDetails/{gameId}"
        const val argument0: String = "gameId"
    }
}