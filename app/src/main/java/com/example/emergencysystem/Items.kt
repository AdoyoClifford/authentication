package com.example.emergencysystem

import androidx.annotation.DrawableRes
import androidx.navigation.NavController

data class Items(
    @DrawableRes val image: Int,
    val text: String
)

fun createDataList(): List<Items> {
    val list = mutableListOf<Items>()
    list.add(Items(R.drawable.doctor, text = "Doctor"))
    list.add(Items(R.drawable.ic_ambulance, text = "Ambulance"))
    list.add(Items(R.drawable.hospital, text = "Find a hospital"))
    list.add(Items(R.drawable.contact, text = "Next of kin"))

    return list
}
