package com.example.sportshub.core.data.source.local

import com.example.sportshub.core.data.source.local.entity.SportEntity
import com.example.sportshub.core.data.source.local.room.SportDao
import io.reactivex.Flowable

class LocalDataSource(private val sportDao: SportDao) {

    fun getAllSport(): Flowable<List<SportEntity>> = sportDao.getAllSport()

    fun insertSport(sportList: List<SportEntity>) = sportDao.insertSport(sportList)

    fun getFavoriteSport(): Flowable<List<SportEntity>> = sportDao.getFavoriteSport()

    fun setFavoriteSport(sport: SportEntity, newState: Boolean) {
        sport.isFavorite = newState
        sportDao.updateFavoriteSport(sport)
    }
}