package com.vk.movies.dataSource.local

import com.vk.movies.dataSource.MoviesDataSource
import com.vk.movies.model.Movie

class MoviesInMemoryDataSource : MoviesDataSource{
    private val listMovies = mutableListOf<Movie>()
    override fun getAllMovies(): List<Movie> {
        return listMovies
    }

    override fun insertMovie(movie: Movie) {
        listMovies.add(movie)
    }

    override fun insertMovieList(list: List<Movie>) {
        listMovies.addAll(list)
    }

    override fun deleteAllMovies() {
        listMovies.removeAll { true }
    }

    override fun updateMovie(movie: Movie) {
        //listMovies.replaceAll {  }
    }
}