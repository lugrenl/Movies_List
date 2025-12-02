package com.example.movies_list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), MoviesListFragment.OnMovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Загружаем фрагмент со списком фильмов только при первом запуске
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MoviesListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    // Этот метод вызывается из MoviesListFragment при клике на фильм
    override fun onMovieClicked(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieDetailsFragment.newInstance(movie))
            .addToBackStack(null)
            .commit()
    }
}
