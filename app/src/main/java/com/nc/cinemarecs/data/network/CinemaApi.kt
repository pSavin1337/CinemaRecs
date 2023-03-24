package com.nc.cinemarecs.data.network

import com.nc.cinemarecs.data.network.models.CinemaNetworkModel
import retrofit2.http.GET

interface CinemaApi {

    @GET("v1/movie/random")
    suspend fun getCinemaData(): CinemaNetworkModel

}