package com.example.movies_list.data

import com.example.movies_list.R
import com.example.movies_list.entity.Actor
import com.example.movies_list.entity.Movie

object MoviesDataSource {
    fun getMovies(): List<Movie> {

        val actors = listOf(
            Actor("Carl Weathers", R.drawable.carl_weathers),
            Actor("Chris Bartlett", R.drawable.chris_bartlett),
            Actor("Gina Carano", R.drawable.gina_carano),
            Actor("Misty Rosas", R.drawable.misty_rosas),
            Actor("Pedro Pascal", R.drawable.pedro_pascal),
            Actor("Rio Hackford", R.drawable.rio_hackford)
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