package com.example.sportshub.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sport(
    val idTeam: String,
    val strTeam: String,
    val strTeamAlternate: String,
    val strCountry: String,
    val strSport: String,
    val strBadge: String,
    val intFormedYear: String? = null,
    val strFanart1: String? = null,
    val strDescriptionEN: String,
    val isFavorite: Boolean = false
) : Parcelable