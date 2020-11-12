package com.vk.movies.ui.movies

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vk.movies.MoviesApp
import com.vk.movies.R
import com.vk.movies.model.DurationFilter
import com.vk.movies.model.Movie
import com.vk.movies.test.getTestMovieList
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.select_filter.view.*
import kotlinx.android.synthetic.main.stats_dialog.view.*

class MoviesFragment : Fragment() {
    val viewModel: MoviesViewModel by viewModels()
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

        val movies: List<Movie> = viewModel.getAllMovies()
        val adapter = MoviesAdapter(movies)
        recyclerViewMovies.adapter = adapter
        recyclerViewMovies.layoutManager = LinearLayoutManager(context)
        
        addMovieButton.setOnClickListener {
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
            viewModel.deleteAllMovies()
        }
        statsButton.setOnClickListener {
            val minDurationMovie = viewModel.minDurationMovie()
            val averageDuration = viewModel.averageDuration()

            /*Toast.makeText(context, "фильм с минимальной продолжительностью: ${minDurationMovie.name}. "
                    + "Продолжительность:${minDurationMovie.duration}"
                    + "Средняя продолжительность фильма: ${averageDuration}",
                Toast.LENGTH_SHORT).show()*/
            val view = LayoutInflater.from(requireContext()).inflate(R.layout.stats_dialog, null)
            view.averageDurationTextView.text = averageDuration.toString()
            if (minDurationMovie != null)
                view.minDurationTextView.text = minDurationMovie.duration.toString()
            else
                view.minDurationTextView.text = "no movies found"
            val builder =  AlertDialog.Builder(requireContext())
            builder.setView(view)
                .setTitle("Statistics")
                .setNegativeButton("Close"){dialog, which ->
                }
                .create()
                .show()
        }
    }

}
