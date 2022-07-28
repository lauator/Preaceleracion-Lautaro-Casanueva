package com.example.cinemapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cinemapp.data.database.dao.MovieDao
import com.example.cinemapp.data.model.MovieDetail

@Database(entities = [MovieDetail::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
}