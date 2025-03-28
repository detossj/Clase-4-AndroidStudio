package com.deto.selectusertype
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class SecondPage( val id: Int )

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost( navController = navController ,startDestination = Home){
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<SecondPage> { backStackEntry ->
            val args = backStackEntry.toRoute<SecondPage>()
            SecondPageScreen(navController = navController, id = args.id)
        }
    }
}