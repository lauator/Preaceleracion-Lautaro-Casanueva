package com.example.cinemapp.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.BuildConfig
import com.example.cinemapp.data.model.Movie
import com.example.cinemapp.data.MovieRepository
import com.example.cinemapp.data.utils.RepositoryError
import com.example.cinemapp.data.utils.RepositoryResponse
import com.example.cinemapp.data.utils.ResponseListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {


    private val _listMovie = MutableLiveData<List<Movie>>()
    val listMovie : LiveData<List<Movie>>
        get() = _listMovie


    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error


    fun load(page : Int = 1){
        _error.value = null
        _listMovie.value = null

        repository.getPopularMovies(listener = object : ResponseListener<List<Movie>> {
            override fun onResponse(response: RepositoryResponse<List<Movie>>) {
                _listMovie.value = response.data
            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message

            }
        }, BuildConfig.API_KEY, page )


    }


}