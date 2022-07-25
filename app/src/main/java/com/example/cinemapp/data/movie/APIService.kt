package com.example.cinemapp.data.movie

import com.example.cinemapp.data.dto.MovieDetail
import com.example.cinemapp.data.dto.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {

    @GET
    suspend fun getPopularMovies(@Url url:String) : Response<MovieResponse>

    @GET
    suspend fun getDetailsOfMovie(@Url url:String) : Response<MovieDetail>


    @GET("popular")
    fun getPopularMovies2(@Query("api_key") apiKey : String, @Query("page") page : Int) : Call<MovieResponse>

    @GET("{movie_id}")
    fun getDetailsOfMovie2(@Path("movie_id") id : Int, @Query("api_key") apiKey : String) : Call<MovieDetail>


}