package com.example.cinemapp.data.network

import com.example.cinemapp.data.RetrofitMovie
import com.example.cinemapp.data.model.Movie
import com.example.cinemapp.data.model.MovieDetail

import com.example.cinemapp.data.model.MovieResponse
import com.example.cinemapp.data.utils.RepositoryError
import com.example.cinemapp.data.utils.RepositoryResponse
import com.example.cinemapp.data.utils.ResponseListener
import com.example.cinemapp.data.utils.Source
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MovieRemoteDataSource @Inject constructor(private val api: APIService ) {


    fun getPopularMovies(listener: ResponseListener<List<Movie>>, apiKey : String, page : Int = 1){



        val service = api.getPopularMovies2(apiKey, page)



        service.enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val movieResponse: MovieResponse? = response.body()
                if (response.isSuccessful && movieResponse != null) {
                    val movies : List<Movie> = movieResponse.results
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
                        message = "Revise su conexion a internet",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }


        })

    }

    fun getDetailsOfMovie(listener: ResponseListener<MovieDetail>, id : Int, apiKey : String ){



        val service = api.getDetailsOfMovie2(id, apiKey)

        service.enqueue(object: Callback<MovieDetail>{
            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                val movieDetail: MovieDetail? = response.body()
                if (response.isSuccessful && movieDetail != null) {
                       listener.onResponse(
                        RepositoryResponse(
                            data = movieDetail,
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

            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message =  "Revise su conexion a internet",
                        code = -1,
                        source = Source.REMOTE
                    )
                )
            }

        })

    }

}