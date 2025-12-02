package com.example.movies_list

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class MoviesListFragment : Fragment(R.layout.fragment_movies_list) {

    // Интерфейс для сообщения MainActivity о клике на фильм
    interface OnMovieClickListener {
        fun onMovieClicked(movie: Movie)
    }

    private var listener: OnMovieClickListener? = null
    private lateinit var moviesGridContainer: LinearLayout
    private val movies: List<Movie> = getMovies()

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

    private fun getMovies(): List<Movie> {

        val actors = listOf(
            Actor("Carl Weathers", R.drawable.carl_weathers),
            Actor("Chris Bartlett", R.drawable.chris_bartlett),
            Actor("Gina Carano", R.drawable.gina_carano),
            Actor("Misty Rosas", R.drawable.misty_rosas),
            Actor("Pedro Pascal",  R.drawable.pedro_pascal),
            Actor("Rio Hackford",  R.drawable.rio_hackford)
        )

        return listOf(
            Movie(
                1,
                R.drawable.star_trek_picard,
                "16+",
                3.0f,
                "Action, Adventure, Drama",
                "Star Trek: Picard",
                "Description for Star Trek.",
                actors
            ),
            Movie(
                2,
                R.drawable.the_mandalorian,
                "12+",
                4.0f,
                "Action, Adventure, Fantasy",
                "The Mandalorian",
                "Description for The Mandalorian.",
                actors
                ),
            Movie(
                3,
                R.drawable.the_witcher,
                "14+",
                5.0f,
                "Action, Adventure, Fantasy",
                "The Witcher",
                "Description for The Witcher.",
                actors
                ),
            Movie(
                4,
                R.drawable.joker,
                "18+",
                4.0f,
                "Crime, Drama, Thriller",
                "Joker",
                "Description for Joker.",
                actors
                ),
            Movie(
                5,
                R.drawable.tenet,
                "18+",
                3.0f,
                "Action, Sci-Fi",
                "Tenet",
                "Description for Tenet.",
                actors
                ),
            Movie(
                6,
                R.drawable.altered_carbon,
                "12+",
                5.0f,
                "Action, Drama, Sci-Fi",
                "Altered Carbon",
                "Description for Altered Carbon.",
                actors
                )
        )
    }
}
