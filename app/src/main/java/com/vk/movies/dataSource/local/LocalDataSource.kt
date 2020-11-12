package com.vk.movies.dataSource.local

import com.vk.movies.dataSource.MoviesDataSource
import com.vk.movies.model.Movie


class MoviesLocalDataSource(val db: MoviesDB): MoviesDataSource {
    override fun getAllMovies(): List<Movie>{
        return db.moviesDAO().getAllMovies()
    }

    override fun insertMovie(movie: Movie){
        db.moviesDAO().insertMovie(movie)
    }

    override fun insertMovieList(list: List<Movie>) {
        for (movie in list)
            db.moviesDAO().insertMovie(movie)
    }

    override fun deleteAllMovies(){
        db.moviesDAO().deleteAllMovies()
    }

    override fun updateMovie(movie: Movie){
        db.moviesDAO().updateMovie(movie)
    }
}