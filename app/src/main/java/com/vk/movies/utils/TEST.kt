package com.vk.movies.utils

import com.vk.movies.model.Movie

fun averageDuration (movieslist: List<Movie>):Int{
    var sum = 0
    for (movie in movieslist)
        sum = sum + movie.duration
    val count = movieslist.size
    val result = sum/count
    return result
}