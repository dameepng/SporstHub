package com.example.sportshub.core.data.source.remote

import com.example.sportshub.core.data.source.remote.network.ApiResponse
import com.example.sportshub.core.data.source.remote.network.ApiService
import com.example.sportshub.core.data.source.remote.response.SportResponse
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteDataSource(private val apiService: ApiService) {

    fun getAllSport(sport: String, country: String): Flowable<ApiResponse<SportResponse>> {
        return apiService.getTeam(sport, country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .map<ApiResponse<SportResponse>> { response ->
                if (response.teams.isNullOrEmpty()) {
                    ApiResponse.Empty
                } else {
                    ApiResponse.Success(response)
                }
            }
            .onErrorReturn { throwable ->
                ApiResponse.Error(throwable.message ?: "Unknown error")
            }
    }
}
