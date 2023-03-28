package com.nc.cinemarecs.di

import com.nc.cinemarecs.domain.repository.LocalRepository
import com.nc.cinemarecs.domain.repository.NetworkRepository
import com.nc.cinemarecs.domain.usecases.GetCinemaRecommendationsUseCase
import com.nc.cinemarecs.domain.usecases.UpdateCinemaRecommendationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetCinemaRecommendationsUseCase(localRepository: LocalRepository) =
        GetCinemaRecommendationsUseCase(localRepository)

    @Provides
    fun provideUpdateCinemaRecommendationsUseCase(
        localRepository: LocalRepository,
        networkRepository: NetworkRepository
    ) =
        UpdateCinemaRecommendationsUseCase(localRepository, networkRepository)

}