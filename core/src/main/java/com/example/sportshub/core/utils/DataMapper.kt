package com.example.sportshub.core.utils

import com.example.sportshub.core.data.source.local.entity.SportEntity
import com.example.sportshub.core.data.source.remote.response.TeamsItem
import com.example.sportshub.core.domain.model.Sport

object DataMapper {

    fun mapResponsesToEntities(input: List<TeamsItem>): List<SportEntity> {
        return input.map {
            SportEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strTeamAlternate = it.strTeamAlternate,
                strCountry = it.strCountry,
                strSport = it.strSport,
                strBadge = it.strBadge,
                intFormedYear = it.intFormedYear,
                strFanart1 = it.strFanart1,
                strDescriptionEN = it.strDescriptionEN,
                isFavorite = false
            )
        }
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Sport> {
        return input.map {
            Sport(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strTeamAlternate = it.strTeamAlternate,
                strCountry = it.strCountry,
                strSport = it.strSport,
                strBadge = it.strBadge,
                intFormedYear = it.intFormedYear,
                strFanart1 = it.strFanart1,
                strDescriptionEN = it.strDescriptionEN,
                isFavorite = it.isFavorite
            )
        }
    }

    fun mapDomainToEntity(input: Sport): SportEntity {
        return SportEntity(
            idTeam = input.idTeam,
            strTeam = input.strTeam,
            strTeamAlternate = input.strTeamAlternate,
            strCountry = input.strCountry,
            strSport = input.strSport,
            strBadge = input.strBadge,
            intFormedYear = input.intFormedYear,
            strFanart1 = input.strFanart1,
            strDescriptionEN = input.strDescriptionEN,
            isFavorite = input.isFavorite
        )
    }
}

