package com.vk.movies.dataSource

import com.vk.movies.dataSource.local.MoviesLocalDataSource
import com.vk.movies.dataSource.remote.MoviesRemoteDataSource
import com.vk.movies.model.Movie

class Repository (private val localDataSource: MoviesDataSource, private val remoteDataSource: MoviesDataSource) : MoviesDataSource{
    override fun getAllMovies(): List<Movie> {
        return try {
            val movies = remoteDataSource.getAllMovies()
            localDataSource.insertMovieList(movies)
            movies
        } catch (e: Exception){
            localDataSource.getAllMovies()
        }
    }

    override fun insertMovie(movie: Movie) {
        remoteDataSource.insertMovie(movie)
        localDataSource.insertMovie(movie)
    }

    override fun insertMovieList(list: List<Movie>) {
        remoteDataSource.insertMovieList(list)
        localDataSource.insertMovieList(list)
    }

    override fun deleteAllMovies() {
        remoteDataSource.deleteAllMovies()
        localDataSource.deleteAllMovies()
    }

    override fun updateMovie(movie: Movie) {
        remoteDataSource.updateMovie(movie)
        localDataSource.updateMovie(movie)
    }
}