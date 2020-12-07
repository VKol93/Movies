package com.vk.movies.ui.addmovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.vk.movies.MoviesApp
import com.vk.movies.R
import com.vk.movies.model.Movie
import kotlinx.android.synthetic.main.fragment_add_movie.*

class AddMovieFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMovieButton.setOnClickListener {
            val movie = Movie(
                name = movieNameEditText.text.toString(),
                duration = movieDurationEditText.text.toString().toInt(),
                director = movieDirectorEditText.text.toString(),
                genre = movieGenreEditText.text.toString(),
                country = movieCountryProductionEditText.text.toString(),
                year = movieYearEditText.text.toString().toInt()
            )
            MoviesApp.dataSource.insertMovie(movie)
            Toast.makeText(context, "added", Toast.LENGTH_LONG).show()
            findNavController().popBackStack()
        }
    }
}

/*   val movie = Movie(
          "The Lion King",
          124,
          "qwer",
          "cartoon"
      )
      db.moviesDAO().insertMovie(movie)*/