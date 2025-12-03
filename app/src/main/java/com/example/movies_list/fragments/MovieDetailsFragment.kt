package com.example.movies_list.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.movies_list.R
import com.example.movies_list.entity.Movie

class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie: Movie? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(ARG_MOVIE, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable(ARG_MOVIE)
        }

        movie?.let {
            view.findViewById<ImageView>(R.id.movie_poster_details)?.setImageResource(it.poster)
            view.findViewById<TextView>(R.id.age_limit_details)?.text = it.ageLimit
            view.findViewById<TextView>(R.id.movie_title_details)?.text = it.title
            view.findViewById<TextView>(R.id.movie_genre_details)?.text = it.genre
            view.findViewById<RatingBar>(R.id.movie_rating_details)?.rating = it.rating
            view.findViewById<TextView>(R.id.storyline_text_details)?.text = it.description

            val actorsContainer = view.findViewById<LinearLayout>(R.id.actors_grid_container)
            actorsContainer?.removeAllViews() // Очищаем контейнер

            val inflater = LayoutInflater.from(context)
            for (actor in it.actors) {
                // Убедимся, что контейнер не null, прежде чем добавлять в него View
                actorsContainer?.let { container ->
                    val actorCard = inflater.inflate(R.layout.item_actor_card, container, false)

                    actorCard.findViewById<ImageView>(R.id.actor_poster)?.setImageResource(actor.photo)
                    actorCard.findViewById<TextView>(R.id.actor_name)?.text = actor.name

                    container.addView(actorCard)
                }
            }
        }
    }

    companion object {
        private const val ARG_MOVIE = "movie_arg"

        fun newInstance(movie: Movie): MovieDetailsFragment {
            return MovieDetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_MOVIE, movie)
                }
            }
        }
    }
}