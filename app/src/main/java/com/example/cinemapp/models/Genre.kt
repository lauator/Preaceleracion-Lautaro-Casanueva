package com.example.cinemapp.models

import com.google.gson.annotations.SerializedName

class Genre(@SerializedName("name") val genre:String){
    override fun toString(): String {
        return genre
    }
}