package com.example.emergencysystem.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingSpotDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSpot(spot: ParkingSpotEntity)

    @Delete
    suspend fun deleteSpot(spot: ParkingSpotEntity)

    @Query("SELECT * FROM ParkingSpotEntity")
    fun getParkingSpots(): Flow<List<ParkingSpotEntity>>
}
