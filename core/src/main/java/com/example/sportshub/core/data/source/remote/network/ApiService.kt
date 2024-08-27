package com.example.sportshub.core.data.source.remote.network

import com.example.sportshub.core.data.source.remote.response.SportResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search_all_teams.php")
    fun getTeam(
        @Query("s") sport: String,
        @Query("c") country: String
    ): Flowable<SportResponse>
}
