package com.example.sportshub.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.sportshub.core.data.source.local.entity.SportEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface SportDao {

    @Query("SELECT * FROM sport")
    fun getAllSport(): Flowable<List<SportEntity>>

    @Query("SELECT * FROM sport where isFavorite = 1")
    fun getFavoriteSport(): Flowable<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSport(sport: List<SportEntity>): Completable

    @Update
    fun updateFavoriteSport(sport: SportEntity)
}