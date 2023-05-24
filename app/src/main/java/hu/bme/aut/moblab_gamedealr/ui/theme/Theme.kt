package hu.bme.aut.moblab_gamedealr.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

//private val DarkColorPalette = darkColors(
//    primary = Purple400,
//    primaryVariant = Purple700,
//    secondary = Purple100
//)

private val LightColorPalette = lightColors(
    primary = Purple600,
    primaryVariant = Purple700,
    secondary = Purple100

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MobLab_GamedealRTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colors = if (darkTheme) {
//        LightColorPalette
//    } else {
//        LightColorPalette

    val colors = LightColorPalette
//    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}