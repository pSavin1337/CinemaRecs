package com.nc.cinemarecs.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nc.cinemarecs.data.local.models.CinemaLocalModel
import com.nc.cinemarecs.utils.Constants.CINEMA_TABLE_NAME

@Dao
interface CinemaDao {

    @Query("SELECT * FROM $CINEMA_TABLE_NAME")
    suspend fun getCinemaDataList(): List<CinemaLocalModel>

    @Query("DELETE FROM $CINEMA_TABLE_NAME")
    suspend fun deleteCinemaData()

    @Insert
    suspend fun insertCinemaData(cinemaData: List<CinemaLocalModel>)

}