package com.vk.movies

import android.app.Application
import androidx.room.Room
import com.vk.movies.dataSource.MoviesDataSource
import com.vk.movies.dataSource.Repository


import com.vk.movies.dataSource.local.MoviesDB
import com.vk.movies.dataSource.local.MoviesLocalDataSource
import com.vk.movies.dataSource.remote.MoviesRemoteDataSource

class MoviesApp : Application(){
    companion object{
        lateinit var dataSource: MoviesDataSource
    }
    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(applicationContext, MoviesDB::class.java, "DB").allowMainThreadQueries().build()
        val localDataSource = MoviesLocalDataSource(db)
        val remoteDataSource = MoviesRemoteDataSource()
        dataSource = Repository(localDataSource, remoteDataSource)
    }
}