package com.example.emergencysystem.data

import com.example.emergencysystem.domain.model.ParkingSpot
import com.example.emergencysystem.domain.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class ParkingSpotRepositoryImpl(private val dao: ParkingSpotDao): ParkingSpotRepository {
    override suspend fun addParkingSpot(spot: ParkingSpot) {
        dao.insertSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        dao.deleteSpot(spot.toParkingSpotEntity())
    }

    override fun getAllParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toParkingSpot() }
        }
    }


}