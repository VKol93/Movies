package com.vk.movies

import android.app.Application
import androidx.room.Room

class MoviesApp : Application(){
    //val db = Room.databaseBuilder(requireContext(), MoviesDB::class.java, "DB").allowMainThreadQueries().build()
    override fun onCreate() {
        super.onCreate()
    }
}