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
    var movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama")
    var movie3 = Movie("Revolver", 160,"Gay Richi", "drama")
    val movie4 = Movie("The Lion King", 135, "Gay Richi", "cartoon")
    val movie5 = Movie("The dead poets Society", 140, "Gay Richi", "drama")


    return listOf(movie1, movie2, movie3, movie4,movie5)
}
