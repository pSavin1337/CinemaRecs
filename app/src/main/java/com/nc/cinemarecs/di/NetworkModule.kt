package com.nc.cinemarecs.di

import com.google.gson.Gson
import com.nc.cinemarecs.data.network.CinemaApi
import com.nc.cinemarecs.utils.Constants.API_KEY
import com.nc.cinemarecs.utils.Constants.BASE_URL
import com.nc.cinemarecs.utils.Constants.CONNECTION_TIME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(converterFactory: GsonConverterFactory, client: OkHttpClient): CinemaApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
            .create()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideClient() = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIME, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("X-API-KEY", API_KEY)
                .build()
            chain.proceed(newRequest)
        }
        .build()

}