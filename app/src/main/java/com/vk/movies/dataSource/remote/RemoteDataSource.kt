package com.vk.movies.dataSource.remote

import com.vk.movies.dataSource.MoviesDataSource
import com.vk.movies.model.Movie

class MoviesRemoteDataSource : MoviesDataSource {
    override fun getAllMovies(): List<Movie>{
        return emptyList()
    }

    override fun insertMovie(movie: Movie){

    }

    override fun insertMovieList(list: List<Movie>) {

    }

    override fun deleteAllMovies(){

    }

    override fun updateMovie(movie: Movie){

    }
}