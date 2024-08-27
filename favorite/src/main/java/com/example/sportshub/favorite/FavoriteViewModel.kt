package com.example.sportshub.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.sportshub.core.domain.usecase.SportUseCase

class FavoriteViewModel(sportUseCase: SportUseCase) : ViewModel() {
    val favoriteSport = LiveDataReactiveStreams.fromPublisher(sportUseCase.getFavoriteSport())
}