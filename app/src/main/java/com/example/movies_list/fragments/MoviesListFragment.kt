package com.example.movies_list.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movies_list.R
import com.example.movies_list.data.MoviesDataSource
import com.example.movies_list.entity.Movie

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {
    private var listener: OnMovieClickListener? = null
    private lateinit var moviesGridContainer: LinearLayout
    private val movies: List<Movie> = MoviesDataSource.getMovies()

    // Присоединяем listener при создании фрагмента
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        } else {
            throw ClassCastException("$context must implement OnMovieClickListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesGridContainer = view.findViewById(R.id.movies_grid_container)
        populateMoviesGrid()
    }

    private fun populateMoviesGrid() {
        val row1 = moviesGridContainer.getChildAt(0) as LinearLayout
        val row2 = moviesGridContainer.getChildAt(1) as LinearLayout
        val row3 = moviesGridContainer.getChildAt(2) as LinearLayout

        fillCard(row1.getChildAt(0) as ViewGroup, movies[0])
        fillCard(row1.getChildAt(1) as ViewGroup, movies[1])

        fillCard(row2.getChildAt(0) as ViewGroup, movies[2])
        fillCard(row2.getChildAt(1) as ViewGroup, movies[3])

        fillCard(row3.getChildAt(0) as ViewGroup, movies[4])
        fillCard(row3.getChildAt(1) as ViewGroup, movies[5])
    }

    private fun fillCard(card: ViewGroup, movie: Movie) {
        card.findViewById<ImageView>(R.id.movie_poster).setImageResource(movie.poster)
        card.findViewById<TextView>(R.id.age_limit).text = movie.ageLimit
        card.findViewById<RatingBar>(R.id.movie_rating).rating = movie.rating
        card.findViewById<TextView>(R.id.movie_genre).text = movie.genre
        card.findViewById<TextView>(R.id.movie_title).text = movie.title

        card.setOnClickListener {
            // Сообщаем listener'у (MainActivity) о клике
            listener?.onMovieClicked(movie)
        }
    }

    // Отсоединяем listener, чтобы избежать утечек памяти
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    // Интерфейс для сообщения MainActivity о клике на фильм
    interface OnMovieClickListener {
        fun onMovieClicked(movie: Movie)
    }
}