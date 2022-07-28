package com.example.cinemapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemapp.data.model.MovieDetail

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies(): List<MovieDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<MovieDetail>)


}