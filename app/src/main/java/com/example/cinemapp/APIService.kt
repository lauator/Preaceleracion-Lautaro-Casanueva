package com.example.cinemapp

import com.example.cinemapp.models.MovieDetail
import com.example.cinemapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET("popular?api_key=64447ce8fb6641bd74e3c4e5ddda6697&language=en-US&page=1")
    suspend fun getPopularMovies() : Response<MovieResponse>

    @GET
    suspend fun getDetailsOfMovie(@Url url:String) : Response<MovieDetail>
}