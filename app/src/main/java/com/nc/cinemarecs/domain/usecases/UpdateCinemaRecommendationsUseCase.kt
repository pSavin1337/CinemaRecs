package com.nc.cinemarecs.domain.usecases

import com.nc.cinemarecs.domain.repository.LocalRepository
import com.nc.cinemarecs.domain.repository.NetworkRepository
import javax.inject.Inject

class UpdateCinemaRecommendationsUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val networkRepository: NetworkRepository
) {

    suspend fun execute() {
        val result = networkRepository.getCinemaData()
        localRepository.updateCinemaData(result)
    }

}