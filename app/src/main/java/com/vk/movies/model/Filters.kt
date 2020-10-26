package com.vk.movies.model


abstract class Filter(){
    abstract fun isFiltered(movie: Movie): Boolean
    
    fun filterMovies(movies:List<Movie>): List<Movie>{
        val result = mutableListOf<Movie>()
        for (movie in movies)
            if (isFiltered(movie))
                result.add(movie)
        return result
    }
}
class DurationFilter(val minDuration: Int, val maxDuration: Int): Filter(){
    override fun isFiltered(movie: Movie): Boolean{
        return movie.duration in (minDuration..maxDuration)
    }
}
class GenreFilter(val genre: String): Filter(){
    override fun isFiltered(movie: Movie): Boolean{
        return movie.genre == genre
    }
}
class DirectorFilter(val director: String): Filter(){
    override fun isFiltered(movie: Movie): Boolean{
        return movie.director == director
    }
}