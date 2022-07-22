package com.example.cinemapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.APIService
import com.example.cinemapp.RetrofitMovie
import com.example.cinemapp.models.Movie
import com.example.cinemapp.models.MovieResponse
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var listMovie: MutableLiveData<List<Movie>> = MutableLiveData()

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

     fun getPopularMovies(page: Int) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            val call: Response<MovieResponse> =
                RetrofitMovie.getRetrofit().create(APIService::class.java).getPopularMovies("popular?api_key=64447ce8fb6641bd74e3c4e5ddda6697&language=en-US&page=$page")

            val response: MovieResponse? = call.body()


            if (call.isSuccessful) {

                val movies: List<Movie> = response?.results ?: emptyList()

                listMovie.postValue(movies)




            }


        }
    }

}