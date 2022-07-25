package com.example.emergencysystem.di

import android.app.Application
import androidx.room.Room
import com.example.emergencysystem.data.DoctorsDataBase
import com.example.emergencysystem.data.DoctorsRepositoryImpl
import com.example.emergencysystem.domain.repository.DoctorsSpotRepository
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
    fun provideDoctorsDatabase(app: Application): DoctorsDataBase {
        return Room.databaseBuilder(app,
            DoctorsDataBase::class.java,
            "parking_spot_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDoctorsRepository(db: DoctorsDataBase): DoctorsSpotRepository {
        return DoctorsRepositoryImpl(db.dao)
    }

}