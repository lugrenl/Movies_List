package com.example.movies_list

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailsActivity : AppCompatActivity() {
    private var actorsGridContainer: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        actorsGridContainer = findViewById<LinearLayout>(R.id.actors_grid_container)
        populateActorsGrid()

        // Получаем данные о фильме
        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("movie", Movie::class.java)
        } else {
            intent.getParcelableExtra<Movie>("movie")
        }
        if (movie != null) {
            setupMovieDetails(movie)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupMovieDetails(movie: Movie) {
        val poster = findViewById<ImageView>(R.id.movie_poster_details)
        val ageLimit = findViewById<TextView>(R.id.age_limit_details)
        val title = findViewById<TextView>(R.id.movie_title_details)
        val rating = findViewById<RatingBar>(R.id.movie_rating_details)
        val genre = findViewById<TextView>(R.id.movie_genre_details)
        val storyLine = findViewById<TextView>(R.id.storyline_text_details)

        poster.setImageResource(movie.poster)
        ageLimit.text = movie.ageLimit
        title.text = movie.title
        rating.rating = movie.rating
        genre.text = movie.genre
        storyLine.text = "Это хороший фильм с интересным сюжетом, не даром его назвали " + movie.title
    }

    private fun populateActorsGrid() {
        val actors = this.actors

        for (i in 0 until actorsGridContainer!!.childCount) {
            // Заполняем ряд
            fillCard((actorsGridContainer!!.getChildAt(i) as ViewGroup?)!!, actors[i]!!)
        }
    }

    private fun fillCard(card: ViewGroup, actor: Actor) {
        val poster = card.findViewById<ImageView>(R.id.actor_poster)
        val actorName = card.findViewById<TextView>(R.id.actor_name)

        poster.setImageResource(actor.poster)
        actorName.text = actor.name
    }

    private val actors: MutableList<Actor?>
        get() {
            val actors: MutableList<Actor?> = ArrayList()

            actors.add(Actor(1, R.drawable.carl_weathers, "Carl Weathers"))
            actors.add(Actor(2, R.drawable.chris_bartlett, "Chris Bartlett"))
            actors.add(Actor(3, R.drawable.gina_carano, "Gina Carano"))
            actors.add(Actor(4, R.drawable.misty_rosas, "Misty Rosas"))
            actors.add(Actor(5, R.drawable.pedro_pascal, "Pedro Pascal"))
            actors.add(Actor(6, R.drawable.rio_hackford, "Rio Hackford"))

            return actors
        }
}
