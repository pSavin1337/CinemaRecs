package com.nc.cinemarecs.data.local

import com.nc.cinemarecs.data.local.dao.CinemaDao
import com.nc.cinemarecs.data.local.models.toCinemaEntity
import com.nc.cinemarecs.data.local.models.toCinemaLocalModel
import com.nc.cinemarecs.domain.entities.CinemaEntity
import com.nc.cinemarecs.domain.repository.LocalRepository
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val cinemaDao: CinemaDao) : LocalRepository {

    override suspend fun getCinemaData(): List<CinemaEntity> =
        cinemaDao.getCinemaDataList().map { it.toCinemaEntity() }

    override suspend fun updateCinemaData(cinemaEntityList: List<CinemaEntity>) {
        cinemaDao.deleteCinemaData()
        cinemaDao.insertCinemaData(cinemaEntityList.map { it.toCinemaLocalModel() })
    }

}