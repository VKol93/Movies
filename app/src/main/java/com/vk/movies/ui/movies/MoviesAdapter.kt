package com.vk.movies.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vk.movies.MoviesApp
import com.vk.movies.R
import com.vk.movies.model.Movie
import kotlinx.android.synthetic.main.movie_description.view.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter(val movies: List<Movie>, val clickListener: OnMovieClickListener?): RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val viewHolder = MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
        return viewHolder
    }
    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.addToFavoriteButton.setOnClickListener{
            movie.isInFavorite = !movie.isInFavorite
            MoviesApp.db.moviesDAO().updateMovie(movie)
        }
        holder.bind(movies[position], clickListener)
    }
}
class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(movie: Movie, clickListener: OnMovieClickListener?){
        itemView.movieName.text = movie.name
        itemView.movieDirector.text = movie.director
        itemView.movieDuration.text = movie.duration.toString()
        itemView.movieGenre.text = movie.genre
        itemView.setOnClickListener {
            clickListener?.onItemClick(movie, adapterPosition)
        }

    }
}
interface OnMovieClickListener{
    fun onItemClick(movie: Movie, position: Int)
}