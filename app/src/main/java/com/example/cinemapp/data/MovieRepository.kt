package com.example.cinemapp.data

import com.example.cinemapp.data.database.dao.MovieDao
import com.example.cinemapp.data.model.Movie
import com.example.cinemapp.data.model.MovieDetail
import com.example.cinemapp.data.network.MovieRemoteDataSource
import com.example.cinemapp.data.utils.ResponseListener
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) {

    fun getPopularMovies(listener: ResponseListener<List<Movie>>, apiKey: String, page: Int) {
        remoteDataSource.getPopularMovies(listener, apiKey, page)
    }

    fun getDetailsOfMovie(listener: ResponseListener<MovieDetail>, id: Int, apiKey: String) {
        remoteDataSource.getDetailsOfMovie(listener, id, apiKey)
    }




}