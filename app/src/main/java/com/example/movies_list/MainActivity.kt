package com.example.movies_list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var moviesGridContainer: LinearLayout? = null
    private var movies: MutableList<Movie?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        moviesGridContainer = findViewById(R.id.movies_grid_container)

        if (movies == null) {
            movies = getMovies()
        }
        populateMoviesGrid()
    }

    private fun populateMoviesGrid() {
        // Получаем все ряды
        val row1 = moviesGridContainer!!.getChildAt(0) as LinearLayout
        val row2 = moviesGridContainer!!.getChildAt(1) as LinearLayout
        val row3 = moviesGridContainer!!.getChildAt(2) as LinearLayout

        // Заполняем первый ряд
        fillCard((row1.getChildAt(0) as ViewGroup?)!!, movies!![0]!!)
        fillCard((row1.getChildAt(1) as ViewGroup?)!!, movies!![1]!!)

        // Заполняем второй ряд
        fillCard((row2.getChildAt(0) as ViewGroup?)!!, movies!![2]!!)
        fillCard((row2.getChildAt(1) as ViewGroup?)!!, movies!![3]!!)

        // Заполняем третий ряд
        fillCard((row3.getChildAt(0) as ViewGroup?)!!, movies!![4]!!)
        fillCard((row3.getChildAt(1) as ViewGroup?)!!, movies!![5]!!)
    }

    private fun fillCard(card: ViewGroup, movie: Movie) {
        val poster = card.findViewById<ImageView>(R.id.movie_poster)
        val ageLimit = card.findViewById<TextView>(R.id.age_limit)
        val rating = card.findViewById<RatingBar>(R.id.movie_rating)
        val genre = card.findViewById<TextView>(R.id.movie_genre)
        val title = card.findViewById<TextView>(R.id.movie_title)

        poster.setImageResource(movie.poster)
        ageLimit.text = movie.ageLimit
        rating.rating = movie.rating
        genre.text = movie.genre
        title.text = movie.title

        card.setOnClickListener { _: View? ->
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }
    }

    private fun getMovies(): MutableList<Movie?> {
        val movies: MutableList<Movie?> = ArrayList()

        movies.add(
            Movie(
                1,
                R.drawable.star_trek_picard,
                "16+",
                3.0f,
                "Action, Adventure, Drama",
                "Star Trek: Picard"
            )
        )
        movies.add(
            Movie(
                2,
                R.drawable.the_mandalorian,
                "12+",
                4.0f,
                "Action, Adventure, Fantasy",
                "The Mandalorian"
            )
        )
        movies.add(
            Movie(
                3,
                R.drawable.the_witcher,
                "14+",
                5.0f,
                "Action, Adventure, Fantasy",
                "The Witcher"
            )
        )
        movies.add(
            Movie(
                4,
                R.drawable.joker,
                "18+",
                4.0f,
                "Crime, Drama, Thriller",
                "Joker"
            )
        )
        movies.add(
            Movie(
                5,
                R.drawable.tenet,
                "18+",
                3.0f,
                "Action, Sci-Fi",
                "Tenet"
            )
        )
        movies.add(
            Movie(
                6,
                R.drawable.altered_carbon,
                "12+",
                5.0f,
                "Action, Drama, Sci-Fi",
                "Altered Carbon"
            )
        )

        return movies
    }
}