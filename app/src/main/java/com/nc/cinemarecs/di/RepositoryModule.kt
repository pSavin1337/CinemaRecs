package com.nc.cinemarecs.di

import com.nc.cinemarecs.data.local.LocalRepositoryImpl
import com.nc.cinemarecs.data.network.NetworkRepositoryImpl
import com.nc.cinemarecs.domain.repository.LocalRepository
import com.nc.cinemarecs.domain.repository.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun getNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    fun getLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

}