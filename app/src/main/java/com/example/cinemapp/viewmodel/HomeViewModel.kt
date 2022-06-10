package com.example.cinemapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.APIService
import com.example.cinemapp.RetrofitMovie
import com.example.cinemapp.models.Movie
import com.example.cinemapp.models.MovieResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var listMovie: MutableLiveData<List<Movie>> = MutableLiveData()


    fun refresh() {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MovieResponse> =
                RetrofitMovie.getRetrofit().create(APIService::class.java).getPopularMovies()

            val response: MovieResponse? = call.body()


            if (call.isSuccessful) {

                val movies: List<Movie> = response?.results ?: emptyList()

                listMovie.postValue(movies)


            }


        }
    }

}