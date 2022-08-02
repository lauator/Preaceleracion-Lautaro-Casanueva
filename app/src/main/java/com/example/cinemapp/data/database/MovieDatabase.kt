package com.example.cinemapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemapp.data.database.dao.MovieDao
import com.example.cinemapp.data.model.GenreConverter
import com.example.cinemapp.data.model.MovieDetail

@Database(entities = [MovieDetail::class], version = 1)
@TypeConverters(GenreConverter::class)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
}