package com.vk.movies.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.movies.R
import com.vk.movies.data.Movie
import com.vk.movies.data.getMovies
import com.vk.movies.data.getTestMovieList
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movies, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MoviesAdapter(getTestMovieList())
        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
    }



    class MoviesAdapter(val movies: List<Movie>): RecyclerView.Adapter<MovieViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val viewHolder = MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
            return viewHolder
        }

        override fun getItemCount(): Int = movies.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie)
        }

    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movie){
            itemView.movieName.setText(movie.name)
            itemView.movieDirector.setText(movie.director)
            itemView.movieDuration.setText(movie.duration.toString())
            itemView.movieGenre.setText(movie.genre)

        }
    }

}
