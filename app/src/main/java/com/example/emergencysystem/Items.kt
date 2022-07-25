package com.example.emergencysystem

import androidx.annotation.DrawableRes

data class Items(
    val id: Int = 0,
    @DrawableRes val image: Int,
    val text: String,
    val route: String = Screens.HomeScreen.route
)

val hospital = Items(
    id = 1,
    image = R.drawable.hospital,
    text = "Hospital",
    Screens.MapScreen.route
)

val doctor = Items(
    id = 2,
    image = R.drawable.doctor,
    text = "Doctor",
    Screens.MapScreen.route
)
val ambulance = Items(
    id = 3,
    image = R.drawable.ic_ambulance,
    text = "Ambulance"
)
val contact = Items(
    id = 4,
    image = R.drawable.contact,
    text = "Next of kin"
)

val allItems = listOf(hospital, doctor, ambulance, contact)

