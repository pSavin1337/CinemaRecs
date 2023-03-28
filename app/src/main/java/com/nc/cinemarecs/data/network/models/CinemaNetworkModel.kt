package com.nc.cinemarecs.data.network.models

import com.nc.cinemarecs.domain.entities.CinemaEntity

data class CinemaNetworkModel(
    val name: String?,
    val description: String?,
    val poster: Poster,
    val videos: Video
)

data class Poster(
    val url: String?
)

data class Video(
    val trailers: List<Trailer>
)

data class Trailer(
    val url: String?
)

fun CinemaNetworkModel.toCinemaEntity() =
    CinemaEntity(
        name = name,
        description = description,
        poster = poster.url,
        trailer = videos.trailers[0].url
    )
