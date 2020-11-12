package com.vk.movies.utils

import com.vk.movies.model.Movie
import com.vk.movies.test.getTestMovieList

/*
Написать функцию которая принимает на вход список фильмов и
имя режиссера и возвращает количество фильмов, которые снял
этот режиссер. Объявление класса Movie - из нашего проекта*/

fun main(){
    val result = directorMoviesCount(getTestMovieList(), "Gay Richi")
    println(result)
}

fun directorMoviesCount (movies: List<Movie>, directorName: String):Int {
    val result = directorMoviesList(movies, directorName)
    return result.size
}

fun directorMoviesList (movies: List<Movie>, directorName: String):List<Movie> {
    val directorsMovies = mutableListOf<Movie>()
    for (movie in movies) {
        if (movie.director == directorName)
            directorsMovies.add(movie)
    }
    return directorsMovies
}