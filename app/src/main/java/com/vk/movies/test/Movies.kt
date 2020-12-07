package com.vk.movies.test

import com.vk.movies.model.Movie
import com.vk.movies.model.MovieStorage


fun getTestMoviesStorage(): MovieStorage {
    var movie1 = Movie("Titanic", 130, "Cameron", "Action","usa", 1990)
    val movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama", "usa", 1999)
    val movieStorage = MovieStorage()
    movieStorage.addMovie(movie1)
    movieStorage.addMovie(movie2)
    return movieStorage
}

fun getTestMovieList(): List<Movie>{
    var movie1 = Movie("Titanic", 130, "Cameron", "Action", "usa", 1990)
    var movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama", "usa", 1999)
    var movie3 = Movie("Revolver", 160,"Gay Richi", "drama","england", 2004)
    val movie4 = Movie("The Lion King", 135, "Gay Richi", "cartoon", "usa", 1980)
    val movie5 = Movie("The dead poets Society", 140, "Gay Richi", "drama", "usa", 1994)


    return listOf(movie1, movie2, movie3, movie4,movie5)
}

