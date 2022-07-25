package com.example.emergencysystem.domain.repository

import com.example.emergencysystem.domain.model.Doctors
import kotlinx.coroutines.flow.Flow
interface DoctorsSpotRepository {
    suspend fun addDoctors(spot: Doctors)

    suspend fun deleteDoctors(spot: Doctors)

    fun getAllDoctors(): Flow<List<Doctors>>
}