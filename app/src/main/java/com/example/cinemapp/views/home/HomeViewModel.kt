package com.example.cinemapp.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.BuildConfig
import com.example.cinemapp.data.movie.APIService
import com.example.cinemapp.data.RetrofitMovie
import com.example.cinemapp.data.dto.Movie
import com.example.cinemapp.data.dto.MovieResponse
import com.example.cinemapp.data.movie.MovieRepository
import com.example.cinemapp.data.utils.RepositoryError
import com.example.cinemapp.data.utils.RepositoryResponse
import com.example.cinemapp.data.utils.ResponseListener
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {

    //var listMovie: MutableLiveData<List<Movie>> = MutableLiveData()
    private val _listMovie = MutableLiveData<List<Movie>>()
    val listMovie : LiveData<List<Movie>>
        get() = _listMovie


    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error


    fun load(){
        _error.value = null
        _listMovie.value = null

        repository.getPopularMovies(listener = object : ResponseListener<List<Movie>> {
            override fun onResponse(response: RepositoryResponse<List<Movie>>) {
                _listMovie.value = response.data
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message

            }
        }, BuildConfig.API_KEY, 1 )


    }




    /*val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }*/

     /*fun getPopularMovies(page: Int) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler).launch {
            val call: Response<MovieResponse> =
                RetrofitMovie.getRetrofit().create(APIService::class.java).getPopularMovies("popular?api_key=64447ce8fb6641bd74e3c4e5ddda6697&language=en-US&page=$page")

            val response: MovieResponse? = call.body()


            if (call.isSuccessful) {

                val movies: List<Movie> = response?.results ?: emptyList()

                listMovie.postValue(movies)




            }


        }
    }*/

}