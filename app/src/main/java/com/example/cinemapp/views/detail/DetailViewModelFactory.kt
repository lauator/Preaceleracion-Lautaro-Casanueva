package com.example.cinemapp.views.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinemapp.data.movie.MovieDataSource
import com.example.cinemapp.data.movie.MovieRepository


class DetailViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val dataSource = MovieDataSource()
        val repository = MovieRepository(dataSource)
        return DetailViewModel(repository) as T
    }

}