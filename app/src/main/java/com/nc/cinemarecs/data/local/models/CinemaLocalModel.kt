package com.nc.cinemarecs.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nc.cinemarecs.domain.entities.CinemaEntity
import com.nc.cinemarecs.utils.Constants.CINEMA_TABLE_NAME

@Entity(tableName = CINEMA_TABLE_NAME)
data class CinemaLocalModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val poster: String,
    val description: String,
    val trailer: String
)

fun CinemaLocalModel.toCinemaEntity() =
    CinemaEntity(
        name = name,
        poster = poster,
        description = description,
        trailer = trailer
    )

fun CinemaEntity.toCinemaLocalModel() =
    CinemaLocalModel(
        name = name!!,
        poster = poster!!,
        description = description!!,
        trailer = trailer!!
    )