package com.vk.movies.utils

import com.vk.movies.model.Movie
import com.vk.movies.test.getTestMovieList

fun main(){
    val result = minDurationMovie(getTestMovieList())
    println(result)
}

fun minDurationMovie (movieslist: List<Movie>): Movie? {
    if (movieslist.isEmpty())
        return null
    var minDurationMovie = movieslist[0]
    for (movie in movieslist){
        if (minDurationMovie.duration > movie.duration)
            minDurationMovie = movie
    }
    return minDurationMovie
}

fun getAverageDuration (movieslist: List<Movie>):Int?{
    if (movieslist.isEmpty())
        return null
    var sum = 0
    for (movie in movieslist)
        sum = sum + movie.duration
    val count = movieslist.size
    val result = sum/count
    return result
}






/*
fun averageAge (listusers: List<User>):Int{
    var sum = 0
    for (user in listusers)
        sum = sum + user.age //sum +=user.age
    val count = listusers.size
    val result = sum/count
    return result //sum/listusers.size
}*/

/*
fun averageAge (listEmployee: List<Employee>):Int{
    */
/* var sum = 0
     for (user in listEmployee)
         sum = sum + user.age //sum +=user.age*//*

    val sum = sumAge(listEmployee)
    val count = listEmployee.size
    val result = sum/count
    return result //sum/listusers.size
}

fun sumAge (listEmployee: List<Employee>):Int{
    var sum = 0
    for (user in listEmployee)
        sum = sum + user.age //sum +=user.age
    return sum
}
*/
