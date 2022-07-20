package com.example.emergencysystem.presentation

import com.example.emergencysystem.domain.model.ParkingSpot
import com.google.maps.android.compose.MapProperties

data class MapScreenState(
    val properties: MapProperties = MapProperties(),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFallout: Boolean = false,
)
