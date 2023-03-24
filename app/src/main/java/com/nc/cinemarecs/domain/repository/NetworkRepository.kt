package com.nc.cinemarecs.domain.repository

import com.nc.cinemarecs.domain.entities.CinemaEntity

interface NetworkRepository {

    suspend fun getCinemaData(): List<CinemaEntity>

}