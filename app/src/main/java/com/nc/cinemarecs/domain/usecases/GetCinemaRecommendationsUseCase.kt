package com.nc.cinemarecs.domain.usecases

import com.nc.cinemarecs.domain.entities.CinemaEntity
import com.nc.cinemarecs.domain.repository.LocalRepository
import javax.inject.Inject

class GetCinemaRecommendationsUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend fun execute(): List<CinemaEntity> = localRepository.getCinemaData()

}