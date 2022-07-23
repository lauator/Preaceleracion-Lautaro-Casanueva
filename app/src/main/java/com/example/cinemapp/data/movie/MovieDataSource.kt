package com.example.cinemapp.data.movie

import com.example.cinemapp.data.RetrofitMovie
import com.example.cinemapp.data.dto.Movie

import com.example.cinemapp.data.dto.MovieResponse
import com.example.cinemapp.data.utils.RepositoryError
import com.example.cinemapp.data.utils.RepositoryResponse
import com.example.cinemapp.data.utils.ResponseListener
import com.example.cinemapp.data.utils.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieDataSource {

    fun getPopularMovies(listener: ResponseListener<List<Movie>>, apiKey : String, page : Int = 1){

        val service = RetrofitMovie.instance.create(APIService::class.java).getPopularMovies2(apiKey, page)



        service.enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val activity: MovieResponse? = response.body()
                if (response.isSuccessful && activity != null) {
                    val movies : List<Movie> = activity.results
                    listener.onResponse(
                        RepositoryResponse(
                            data = movies,
                            source = Source.REMOTE
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "El servidor rechazó la solicitud",
                            code = response.code(),
                            source = Source.REMOTE
                        )
                    )
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Error inesperado",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }


        })






    }
}