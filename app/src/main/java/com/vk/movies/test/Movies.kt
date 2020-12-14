package com.vk.movies.test

import com.vk.movies.model.Movie
import com.vk.movies.model.MovieStorage


fun getTestMoviesStorage(): MovieStorage {
    var movie1 = Movie("Titanic", 130, "Cameron", "Action")
    val movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama")
    val movieStorage = MovieStorage()
    movieStorage.addMovie(movie1)
    movieStorage.addMovie(movie2)
    return movieStorage
}

fun getTestMovieList(): List<Movie>{
    var movie1 = Movie("Titanic", 130, "Cameron", "Action")
    val movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama")
    return listOf(movie1, movie2)
}

