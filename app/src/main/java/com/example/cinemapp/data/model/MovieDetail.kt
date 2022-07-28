package com.example.cinemapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_table")
data class MovieDetail(@ColumnInfo(name = "id")@SerializedName("id") val id:Int,
                       @ColumnInfo(name = "title")@SerializedName("title") val title:String,
                       @ColumnInfo(name = "poster_path")@SerializedName("poster_path") val poster_path:String,
                       @ColumnInfo(name = "genres")@SerializedName("genres") val genres:ArrayList<Genre>,
                       @ColumnInfo(name = "original_language")@SerializedName("original_language") val original_language:String,
                       @ColumnInfo(name = "popularity")@SerializedName("popularity") val popularity:Double,
                       @ColumnInfo(name = "release_date")@SerializedName("release_date") val release_date:String,
                       @ColumnInfo(name = "overview")@SerializedName("overview") val overview:String)