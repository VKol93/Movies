package com.vk.movies

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vk.movies.dataSource.local.MoviesDB

class MoviesApp : Application(){
    companion object{
        lateinit var db: MoviesDB
    }
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, MoviesDB::class.java, "DB").allowMainThreadQueries().build()
    }
}