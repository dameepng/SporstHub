package com.example.sportshub.core.domain.repository

import com.example.sportshub.core.data.source.Resource
import com.example.sportshub.core.domain.model.Sport
import io.reactivex.Flowable

interface ISportRepository {
    fun getAllSport(sport: String, country: String): Flowable<Resource<List<Sport>>>
    fun getFavoriteSport(): Flowable<List<Sport>>
    fun setFavoriteSport(sport: Sport, state: Boolean)
}
