package com.vk.movies.dataSource.local

import androidx.room.*
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

    @Update
    fun updateMovie(movie: Movie)

    @Query("DELETE FROM Movies")
    fun deleteAllMovies()
}


