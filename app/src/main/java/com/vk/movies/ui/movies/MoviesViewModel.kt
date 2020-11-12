package com.vk.movies.ui.movies

import androidx.lifecycle.ViewModel
import com.vk.movies.MoviesApp
import com.vk.movies.model.Movie
import com.vk.movies.utils.getAverageDuration
import com.vk.movies.utils.minDurationMovie

class MoviesViewModel : ViewModel(){
    fun getAllMovies(): List<Movie>{
        return MoviesApp.dataSource.getAllMovies()
    }
    fun minDurationMovie(): Movie?{
        return minDurationMovie(getAllMovies())
    }

    fun averageDuration(): Int?{
        return getAverageDuration(getAllMovies())
    }


    fun deleteAllMovies(){
        MoviesApp.dataSource.deleteAllMovies()
    }
}