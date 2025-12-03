package com.example.movies_list

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.movies_list.entity.Movie
import com.example.movies_list.fragments.MovieDetailsFragment
import com.example.movies_list.fragments.MoviesListFragment


class MainActivity : AppCompatActivity(), MoviesListFragment.OnMovieClickListener {

    private var isTabletMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Определяем, в каком режиме мы работаем
        // Если на экране есть details_container, значит, это планшетная разметка.
        isTabletMode = findViewById<View>(R.id.details_container) != null

        // Загружаем фрагмент со списком фильмов только при первом запуске
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.list_container, MoviesListFragment())
                .commit()
        }
    }

    // Этот метод вызывается из MoviesListFragment при клике на фильм
    override fun onMovieClicked(movie: Movie, sharedView: View) {
        val detailsFragment = MovieDetailsFragment.newInstance(movie)

        // Разная логика для телефона и планшета
        if (isTabletMode) {
            // ПЛАНШЕТНЫЙ РЕЖИМ: Показываем детали в правом контейнере
            supportFragmentManager.beginTransaction()
                .replace(R.id.details_container, detailsFragment)
                // Анимация Shared Element здесь не нужна, так как элементы на одном экране
                .commit()
        } else {
            // ТЕЛЕФОННЫЙ РЕЖИМ: Заменяем список на детали с анимацией
            supportFragmentManager.beginTransaction()
                .addSharedElement(sharedView, sharedView.transitionName)
                .replace(R.id.list_container, detailsFragment)
                .addToBackStack(null) // Позволяет вернуться к списку по кнопке "Назад"
                .commit()
        }
    }
}
