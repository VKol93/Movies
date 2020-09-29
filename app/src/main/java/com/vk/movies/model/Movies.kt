package com.vk.movies.model
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Movies")
data class Movie(
    val name: String, 
    val duration: Int, 
    val director: String, 
    val genre: String,
    @PrimaryKey val id: String = UUID.randomUUID().toString()
)


