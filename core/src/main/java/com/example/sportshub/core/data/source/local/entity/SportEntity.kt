package com.example.sportshub.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sport")
data class SportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    var strTeam: String,

    @ColumnInfo(name = "strTeamAlternate")
    var strTeamAlternate: String,

    @ColumnInfo(name = "strCountry")
    var strCountry: String,

    @ColumnInfo(name = "strSport")
    var strSport: String,

    @ColumnInfo(name = "strBadge")
    var strBadge: String,

    @ColumnInfo(name = "intFormedYear")
    var intFormedYear: String? = null,

    @ColumnInfo(name = "strFanart1")
    var strFanart1: String? = null,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)