package com.nc.cinemarecs.data.network

import com.nc.cinemarecs.data.network.models.toCinemaEntity
import com.nc.cinemarecs.domain.entities.CinemaEntity
import com.nc.cinemarecs.domain.repository.NetworkRepository
import com.nc.cinemarecs.utils.Constants.CINEMA_COUNT
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val cinemaApi: CinemaApi):
    NetworkRepository {

    override suspend fun getCinemaData(): List<CinemaEntity> {
        val cinemaList = ArrayList<CinemaEntity>()
        repeat(CINEMA_COUNT) {
            cinemaList.add(cinemaApi.getCinemaData().toCinemaEntity())
        }
        return cinemaList
    }

}