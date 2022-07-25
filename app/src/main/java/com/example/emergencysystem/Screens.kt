package com.example.emergencysystem

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash")
    object LoginScreen: Screens("login")
    object RegisterScreen: Screens("register")
    object HomeScreen: Screens("home")
    object ProfileScreen: Screens("profile")
    object EmergencyScreen: Screens("emergency")
    object MapScreen: Screens("doctor")

}
