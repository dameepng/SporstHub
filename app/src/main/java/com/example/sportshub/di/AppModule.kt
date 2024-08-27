package com.example.sportshub.di

import com.example.sportshub.core.domain.usecase.SportInteractor
import com.example.sportshub.core.domain.usecase.SportUseCase
import com.example.sportshub.detail.DetailSportViewModel
import com.example.sportshub.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailSportViewModel(get()) }
}