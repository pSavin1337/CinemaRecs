package com.nc.cinemarecs.domain.repository

import com.nc.cinemarecs.domain.entities.CinemaEntity

interface LocalRepository {

    suspend fun getCinemaData(): List<CinemaEntity>
    suspend fun updateCinemaData(cinemaEntityList: List<CinemaEntity>)

}