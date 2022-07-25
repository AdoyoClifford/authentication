package com.example.emergencysystem.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DoctorsEntity(
    val lat: Double,
    val lng: Double,
    @PrimaryKey val id: Int? = null
)
