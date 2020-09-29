package com.vk.movies.model

class MovieStorage(){
    private val movies = mutableListOf<Movie>()
    fun addMovie(movie: Movie){
        movies.add(movie)
    }
    fun removeMovie(movie: Movie){
        movies.remove(movie)
    }
    fun getFilteredMovies(filterStorage: FilterStorage): List<Movie>{
        val result = mutableListOf<Movie>()
        for (movie in movies)
            if (filterStorage.filterAll(movie))
                result.add(movie)
        return result
    }
}

class FilterStorage{
    val filters = mutableListOf<Filter>()
    fun addFilter(filter: Filter){
        filters.add(filter)
    }
    fun removeFilter(filter: Filter){
        filters.remove(filter)
    }
    fun filterAll(movie: Movie): Boolean{
        var result = true
        for (filter in filters)
            if (!filter.isFiltered(movie))
                result = false
        return result
    }
}