package com.vk.movies.data

abstract class Filter(){
    abstract fun isFiltered(movie: Movie): Boolean
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


fun getFilters(): FilterStorage{
    val filter1 = DurationFilter(90, 140)
    val filter2 = DirectorFilter("Cameron")
    val filter3 = GenreFilter("Action")
    val filterCollection1 = FilterStorage()
    filterCollection1.addFilter(filter1)
    filterCollection1.addFilter(filter2)
    filterCollection1.addFilter(filter3)
    return filterCollection1
}