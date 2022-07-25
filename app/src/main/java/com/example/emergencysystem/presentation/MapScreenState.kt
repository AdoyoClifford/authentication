package com.example.emergencysystem.presentation

import com.example.emergencysystem.domain.model.Doctors
import com.google.maps.android.compose.MapProperties

data class MapScreenState(
    val properties: MapProperties = MapProperties(),
    val doctorsSpots: List<Doctors> = emptyList(),
    val isFallout: Boolean = false,
)
