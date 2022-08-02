package com.example.cinemapp

import android.app.Application
import androidx.room.Room
import com.example.cinemapp.data.database.MovieDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CinemApp : Application()