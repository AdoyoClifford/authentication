package com.example.emergencysystem.presentation

import com.example.emergencysystem.domain.model.ParkingSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent{
    object ToggleFallout: MapEvent()
    data class onMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val spot: ParkingSpot): MapEvent()

}
