package hu.bme.aut.moblab_gamedealr.ui.main_games

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun GamedealRMainScreen() {
    val navController = rememberNavController()

    val colors = MaterialTheme.colors
//    val systemUiController = rememberSystemUiController()

    var statusBarColor by remember { mutableStateOf(colors.primaryVariant) }
    var navigationBarColor by remember { mutableStateOf(colors.primaryVariant) }


    NavHost(navController = navController, startDestination = NavScreen.Games.route) {
        composable(NavScreen.Games.route) {
            LaunchedEffect(Unit) {
                statusBarColor = colors.primaryVariant
                navigationBarColor = colors.primaryVariant
            }
        }
    }

//    LaunchedEffect(animatedStatusBarColor, animatedNavigationBarColor) {
//        systemUiController.setStatusBarColor(animatedStatusBarColor)
//        systemUiController.setNavigationBarColor(animatedNavigationBarColor)
//    }
}

sealed class NavScreen(val route: String) {

    object Games : NavScreen("Games")

    object Deals : NavScreen("Deals") {

        const val routeWithArgument: String = "Deals/{gameId}"
        const val argument0: String = "gameId"
    }

    object MyDeals : NavScreen("My Deals")
}