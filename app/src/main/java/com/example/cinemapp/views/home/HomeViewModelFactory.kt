package com.example.cinemapp.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinemapp.data.movie.MovieDataSource
import com.example.cinemapp.data.movie.MovieRepository

class HomeViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val dataSource = MovieDataSource()
        val repository = MovieRepository(dataSource)
        return HomeViewModel(repository) as T
    }
}