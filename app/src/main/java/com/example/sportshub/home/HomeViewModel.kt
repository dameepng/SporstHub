package com.example.sportshub.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.sportshub.core.data.source.Resource
import com.example.sportshub.core.domain.model.Sport
import com.example.sportshub.core.domain.usecase.SportUseCase

class HomeViewModel(private val sportUseCase: SportUseCase) : ViewModel() {

    fun getSports(sport: String, country: String): LiveData<Resource<List<Sport>>> {
        return LiveDataReactiveStreams.fromPublisher(sportUseCase.getAllSport(sport, country))
    }
}
