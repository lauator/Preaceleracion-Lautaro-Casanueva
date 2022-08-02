package com.example.cinemapp.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreConverter {
    @TypeConverter
    fun fromJSON(json: String?): List<Genre> {

        return if(json == null){
            emptyList()
        }else{
            val gson = Gson()
            val listType = object : TypeToken<List<Genre>>() {

            }.type
            gson.fromJson(json, listType)
        }

    }

    @TypeConverter
    fun toJSON(generos: List<Genre>): String {
        val gson = Gson()
        return gson.toJson(generos)

    }
}