package com.example.cinemapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinemapp.APIService
import com.example.cinemapp.RetrofitMovie
import com.example.cinemapp.models.Genre

import com.example.cinemapp.models.MovieDetail

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetailViewModel : ViewModel() {

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




    fun getDetailMovie(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<MovieDetail> =
                RetrofitMovie.getRetrofit().create(APIService::class.java)
                    .getDetailsOfMovie("https://api.themoviedb.org/3/movie/$id?api_key=64447ce8fb6641bd74e3c4e5ddda6697&language=en-US")

            val response: MovieDetail? = call.body()


            if (call.isSuccessful) {

                _title.postValue(response?.title.toString())
                _image.postValue("https://image.tmdb.org/t/p/original${response?.poster_path}")
                _language.postValue(response?.original_language)
                _popularity.postValue(response?.popularity)
                _release.postValue(response?.release_date)
                _overview.postValue(response?.overview)




                val genresList: List<Genre> = response?.genres ?: emptyList()
                var genres = ""

                for (element in genresList) {
                    genres += if(genresList.last().equals(element)){
                        "$element"
                    }else{
                        "${element}, "
                    }

                }


                _genre.postValue(genres)

            }


        }
    }


}