package com.example.cinemapp.models

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("title") val title:String, @SerializedName("poster_path") val poster_path:String,
                 @SerializedName("id") val id:Int)