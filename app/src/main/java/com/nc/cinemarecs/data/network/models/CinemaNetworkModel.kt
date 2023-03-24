package com.nc.cinemarecs.data.network.models

import com.nc.cinemarecs.domain.entities.CinemaEntity

data class CinemaNetworkModel(
    val docs: Data
)

data class Data(
    val name: String,
    val description: String,
    val poster: Poster,
    val videos: Video
)

data class Poster(
    val url: String
)

data class Video(
    val trailers: Trailer
)

data class Trailer(
    val url: String
)

fun CinemaNetworkModel.toCinemaEntity() = with(docs) {
    CinemaEntity(
        name = name,
        description = description,
        poster = poster.url,
        trailer = videos.trailers.url
    )
}
