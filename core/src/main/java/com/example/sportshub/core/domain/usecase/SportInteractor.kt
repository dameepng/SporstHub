package com.example.sportshub.core.domain.usecase

import com.example.sportshub.core.domain.model.Sport
import com.example.sportshub.core.domain.repository.ISportRepository

class SportInteractor(private val sportRepository: ISportRepository) : SportUseCase {

    override fun getAllSport(sport: String, country: String) = sportRepository.getAllSport(sport, country)

    override fun getFavoriteSport() = sportRepository.getFavoriteSport()

    override fun setFavoriteSport(sport: Sport, state: Boolean) = sportRepository.setFavoriteSport(sport, state)
}
