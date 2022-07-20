package com.example.emergencysystem.domain.repository

import com.example.emergencysystem.domain.model.ParkingSpot
import kotlinx.coroutines.flow.Flow
interface ParkingSpotRepository {
    suspend fun addParkingSpot(spot: ParkingSpot)

    suspend fun deleteParkingSpot(spot: ParkingSpot)

    fun getAllParkingSpots(): Flow<List<ParkingSpot>>
}