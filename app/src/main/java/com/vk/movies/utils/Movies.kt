package com.vk.movies.utils

import com.vk.movies.model.Filter
import com.vk.movies.model.Movie

fun filterMovies(movies:List<Movie>, filter: Filter):List<Movie>{
    val result = mutableListOf<Movie>()
    for (movie in movies)
        if (filter.isFiltered(movie))
            result.add(movie)
    return result
}
