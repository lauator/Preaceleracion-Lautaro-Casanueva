package com.example.cinemapp.data.dto

import com.example.cinemapp.data.dto.Movie
import com.google.gson.annotations.SerializedName


data class MovieResponse(@SerializedName("results") var results : ArrayList<Movie>)