package com.example.emergencysystem

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.emergencysystem.contacts.ui.add_edit_contact.AddEditContactScreen
import com.example.emergencysystem.contacts.ui.contact_list.ContactListScreen
import com.example.emergencysystem.presentation.HomeScreen
import com.example.emergencysystem.presentation.MapScreen
import com.example.emergencysystem.presentation.SplashScreen
import com.example.emergencysystem.util.Routes
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
          //  LogInScreen(auth = auth , navController = navController)
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

        composable(Routes.TODO_LIST) {
            ContactListScreen(
                onNavigate = {
                    navController.navigate(it.route)
                }
            )
        }
        composable(
            route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
            arguments = listOf(
                navArgument(name = "todoId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            AddEditContactScreen(onPopBackStack = {
                navController.popBackStack()
            })
        }
    }

}