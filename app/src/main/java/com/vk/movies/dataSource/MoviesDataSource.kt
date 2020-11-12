package com.vk.movies.dataSource

import com.vk.movies.dataSource.local.MoviesDB
import com.vk.movies.model.Movie

interface MoviesDataSource{
    fun getAllMovies(): List<Movie>

    fun insertMovie(movie: Movie)

    fun insertMovieList(list: List<Movie>)

    fun deleteAllMovies()

    fun updateMovie(movie: Movie)
}





