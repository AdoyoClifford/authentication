package com.example.emergencysystem.di

import android.app.Application
import androidx.room.Room
import com.example.emergencysystem.data.ParkingSpotDataBase
import com.example.emergencysystem.data.ParkingSpotRepositoryImpl
import com.example.emergencysystem.domain.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDataBase(app: Application): ParkingSpotDataBase {
        return Room.databaseBuilder(app,
            ParkingSpotDataBase::class.java,
            "parking_spot_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDataBase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }

}