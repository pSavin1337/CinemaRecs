package com.nc.cinemarecs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nc.cinemarecs.data.local.dao.CinemaDao
import com.nc.cinemarecs.data.local.models.CinemaLocalModel
import com.nc.cinemarecs.utils.Constants.DATABASE_VERSION

@Database(
    entities = [CinemaLocalModel::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class CinemaDatabase: RoomDatabase() {

    abstract fun cinemaDao(): CinemaDao

}