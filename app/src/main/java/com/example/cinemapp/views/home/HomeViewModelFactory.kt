package com.example.cinemapp.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cinemapp.data.network.MovieRemoteDataSource
import com.example.cinemapp.data.MovieRepository
import javax.inject.Inject

class HomeViewModelFactory  {
    //ViewModelProvider.Factory
    /*override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = MovieRemoteDataSource()
        val repository = MovieRepository(dataSource)
        return HomeViewModel(repository) as T
    }*/



}