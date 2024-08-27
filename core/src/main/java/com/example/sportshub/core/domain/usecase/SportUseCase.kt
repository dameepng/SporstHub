package com.example.sportshub.core.domain.usecase

import com.example.sportshub.core.data.source.Resource
import com.example.sportshub.core.domain.model.Sport
import io.reactivex.Flowable

interface SportUseCase {
    fun getAllSport(sport: String, country: String): Flowable<Resource<List<Sport>>>
    fun getFavoriteSport(): Flowable<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}
