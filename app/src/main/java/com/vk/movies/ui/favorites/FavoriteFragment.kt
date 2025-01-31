package com.vk.movies.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.movies.MoviesApp
import com.vk.movies.R
import com.vk.movies.model.Movie
import com.vk.movies.ui.movies.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_favorite.*


class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_favorite, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movies = MoviesApp.dataSource.getAllMovies()
        val filterMovies = movies.filter{it.isInFavorite}

/*        val result = mutableListOf<Movie>()
        for (movie in movies)
            if (movie.isInFavorite)
                result.add(movie)*/

        val adapter = MoviesAdapter(filterMovies)
        recyclerViewFavorite.adapter = adapter
        recyclerViewFavorite.layoutManager = LinearLayoutManager(context)

    }

}