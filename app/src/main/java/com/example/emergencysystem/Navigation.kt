package com.example.emergencysystem

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.emergencysystem.presentation.HomeScreen
import com.example.emergencysystem.presentation.LogInScreen
import com.example.emergencysystem.presentation.MapScreen
import com.example.emergencysystem.presentation.SplashScreen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Navigation() {
    val auth by lazy {
        Firebase.auth
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController = navController) }
        composable(Screens.LoginScreen.route) {
            LogInScreen(auth = auth , navController = navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screens.MapScreen.route + "/{id}",
        arguments = listOf(navArgument(name = "id"){
            type = NavType.IntType
        })) {entry ->
//            MapScreen(navController, entry.arguments?.getInt("id") ?: 0)
            MapScreen(navController = navController, id = entry.arguments?.getInt("id"))
        }
    }

}