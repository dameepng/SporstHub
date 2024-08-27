package com.example.sportshub.detail

import androidx.lifecycle.ViewModel
import com.example.sportshub.core.domain.model.Sport
import com.example.sportshub.core.domain.usecase.SportUseCase

class DetailSportViewModel(private val sportUseCase: SportUseCase) : ViewModel() {
    fun setFavoriteSport(sport: Sport, newStatus:Boolean) =
        sportUseCase.setFavoriteSport(sport, newStatus)
}