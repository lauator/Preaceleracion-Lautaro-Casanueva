package com.example.cinemapp.models

import com.google.gson.annotations.SerializedName

data class MovieDetail(@SerializedName("title") val title:String,
                       @SerializedName("poster_path") val poster_path:String,
                       @SerializedName("genres") val genres:ArrayList<Genre>,
                       @SerializedName("original_language") val original_language:String,
                       @SerializedName("popularity") val popularity:Double,
                       @SerializedName("release_date") val release_date:String,
                       @SerializedName("overview") val overview:String)