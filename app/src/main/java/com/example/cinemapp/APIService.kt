package com.example.cinemapp

import com.example.cinemapp.models.MovieDetail
import com.example.cinemapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET()
    suspend fun getPopularMovies(@Url url:String) : Response<MovieResponse>

    @GET
    suspend fun getDetailsOfMovie(@Url url:String) : Response<MovieDetail>
}