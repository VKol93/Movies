package com.vk.movies.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Movies")
data class Movie(
    val name: String,
    val duration: Int,
    var director: String,
    val genre: String,
    /*val country:String,
    val year:Int,*/
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    var isInFavorite: Boolean = false
)
