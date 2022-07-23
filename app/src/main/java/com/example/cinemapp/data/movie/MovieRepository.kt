package com.example.cinemapp.data.movie

import com.example.cinemapp.data.dto.Movie
import com.example.cinemapp.data.dto.MovieResponse
import com.example.cinemapp.data.utils.ResponseListener

class MovieRepository(private val remoteDataSource: MovieDataSource) {

    fun getPopularMovies(listener: ResponseListener<List<Movie>>, apiKey : String, page: Int){
        remoteDataSource.getPopularMovies(listener, apiKey, page)

    }

}