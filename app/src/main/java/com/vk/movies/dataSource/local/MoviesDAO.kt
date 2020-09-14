package com.vk.movies.dataSource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vk.movies.model.Movie

@Dao
interface MoviesDAO{
    @Query("SELECT * FROM Movies")
    fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM Movies WHERE duration>120")
    fun getAllLongMovies(): List<Movie>

    @Query("SELECT * FROM Movies WHERE duration>:minDuration")
    fun getMoviesByDuration(minDuration: Int): List<Movie>

    @Insert
    fun insertMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)
}


