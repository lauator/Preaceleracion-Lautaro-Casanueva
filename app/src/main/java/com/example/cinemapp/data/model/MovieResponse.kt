package com.example.cinemapp.data.model

import com.google.gson.annotations.SerializedName


data class MovieResponse(@SerializedName("results") var results : ArrayList<Movie>)