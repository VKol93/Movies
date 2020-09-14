package com.vk.movies.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vk.movies.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesDB : RoomDatabase(){
    abstract fun moviesDAO(): MoviesDAO
}