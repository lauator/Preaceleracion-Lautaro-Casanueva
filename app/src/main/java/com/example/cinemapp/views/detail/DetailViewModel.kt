package com.example.cinemapp.views.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.BuildConfig
import com.example.cinemapp.data.model.Genre

import com.example.cinemapp.data.model.MovieDetail
import com.example.cinemapp.data.MovieRepository
import com.example.cinemapp.data.utils.RepositoryError
import com.example.cinemapp.data.utils.RepositoryResponse
import com.example.cinemapp.data.utils.ResponseListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val _title = MutableLiveData<String>("")
    val title: LiveData<String> = _title

    private val _image = MutableLiveData<String>("")
    val image: LiveData<String> = _image

    private val _genre = MutableLiveData<String>("")
    val genre: LiveData<String> = _genre

    private val _language = MutableLiveData<String>("")
    val language: LiveData<String> = _language

    private val _popularity = MutableLiveData<Double>(0.0)
    val popularity: LiveData<Double> = _popularity

    private val _release = MutableLiveData<String>("")
    val release: LiveData<String> = _release

    private val _overview = MutableLiveData<String>("")
    val overview: LiveData<String> = _overview

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun load(id: Int){
        _error.value = null

        repository.getDetailsOfMovie(listener = object: ResponseListener<MovieDetail>{
            override fun onResponse(response: RepositoryResponse<MovieDetail>) {
                _title.value = response.data.title
                _image.value = "https://image.tmdb.org/t/p/original${response.data.poster_path}"
                _language.value = response.data.original_language
                _popularity.value = response.data.popularity
                _release.value = response.data.release_date
                _overview.value = response.data.overview

                val genresList: List<Genre> = response.data.genres

                var genres = ""

                for (element in genresList) {
                    genres += if (genresList.last() == element) {
                        "$element"
                    } else {
                        "${element}, "
                    }

                }

                _genre.value = genres


            }

            override fun onError(error: RepositoryError) {
                _error.value = error.message
            }

        }, id , BuildConfig.API_KEY)
    }




}