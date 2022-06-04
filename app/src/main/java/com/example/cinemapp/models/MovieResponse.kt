package com.example.cinemapp.models

import com.google.gson.annotations.SerializedName

//TODO la variable results
data class MovieResponse(@SerializedName("results") var results : ArrayList<Movie>)