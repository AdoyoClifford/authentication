package com.example.emergencysystem.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DoctorsEntity::class], version = 1)
abstract class DoctorsDataBase: RoomDatabase() {
    abstract val dao: DoctorsDao
}