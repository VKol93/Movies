package com.vk.movies.data

data class Movie(val name: String, val duration: Int, val director: String, val genre: String)

class MovieStorage(){
    private val movies = mutableListOf<Movie>()
    fun addMovie(movie: Movie){
        movies.add(movie)
    }
    private fun removeMovie(movie: Movie){
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

fun getMovies(): MovieStorage{
    var movie1 = Movie("Titanic", 130, "Cameron", "Action")
    val movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama")
    val movieCollection1 = MovieStorage()
    movieCollection1.addMovie(movie1)
    movieCollection1.addMovie(movie2)
    return movieCollection1
}

fun getTestMovieList(): List<Movie>{
    var movie1 = Movie("Titanic", 130, "Cameron", "Action")
    val movie2 = Movie("Matrix", 120, "fdsfdsf", "Drama")
    return listOf(movie1, movie2)
}

fun filterMovies(movies:List<Movie>, filter:Filter):List<Movie>{
    val result = mutableListOf<Movie>()
    for (movie in movies)
        if (filter.isFiltered(movie))
            result.add(movie)
    return result
}
