package com.vk.movies.ui.movies

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.movies.MoviesApp
import com.vk.movies.R
import com.vk.movies.model.DurationFilter
import com.vk.movies.test.getTestMovieList
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.select_filter.view.*

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

        /*val listener = object: OnMovieClickListener{
            override fun onItemClick(movie: Movie, position: Int) {
                val action = MovieFrag
            }
        }*/

        val movies = MoviesApp.db.moviesDAO().getAllMovies()
        val adapter = MoviesAdapter(movies)
        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)

        addMovieButton.setOnClickListener {
            /*   val movie = Movie(
                "The Lion King",
                124,
                "qwer",
                "cartoon"
            )1
            db.moviesDAO().insertMovie(movie)*/
            findNavController().navigate(R.id.action_navigation_home_to_addMovieFragment)
        }

        filterButton.setOnClickListener {
             val view = LayoutInflater.from(requireContext()).inflate(R.layout.select_filter, null)
             val builder =  AlertDialog.Builder(requireContext())
             builder.setView(view)
                .setTitle("Select Filters")
                .setPositiveButton("Apply"){ dialog, which ->
                    val durationFilter = DurationFilter(
                         view.minDurationEditText.text.toString().toInt(),
                         view.maxDurationEditText.text.toString().toInt()
                    )
                    val filteredMovies = durationFilter.filterMovies(getTestMovieList())
                    //val filteredMovies = filterMovies(getTestMovieList(), durationFilter)
                    val adapter = MoviesAdapter(filteredMovies)
                    recyclerViewMovies.adapter = adapter
                }
                .setNegativeButton("Cancel"){dialog, which ->
                }
                .setNeutralButton("Reset"){dialog, which ->
                }
                .create()
                .show()
        }
        deleteAllButton.setOnClickListener {
            MoviesApp.db.moviesDAO().deleteAllMovies()
        }
    }
}
