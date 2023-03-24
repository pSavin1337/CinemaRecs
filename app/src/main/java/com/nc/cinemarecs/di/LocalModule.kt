package com.nc.cinemarecs.di

import android.content.Context
import androidx.room.Room
import com.nc.cinemarecs.data.local.CinemaDatabase
import com.nc.cinemarecs.data.local.dao.CinemaDao
import com.nc.cinemarecs.utils.Constants.CINEMA_TABLE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CinemaDatabase =
        Room.databaseBuilder(context, CinemaDatabase::class.java, CINEMA_TABLE_NAME)
            .build()

    @Provides
    fun provideWeatherDayDao(database: CinemaDatabase): CinemaDao = database.cinemaDao()

}