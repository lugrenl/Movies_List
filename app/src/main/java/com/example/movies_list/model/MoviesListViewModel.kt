package com.example.movies_list.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies_list.data.MoviesDataSource
import com.example.movies_list.entity.Movie

class MoviesListViewModel : ViewModel() {

    // Используем LiveData для хранения списка фильмов
    // Это позволит фрагменту "подписаться" на данные и автоматически обновлять UI.
    // _movies - это изменяемая версия, видимая только внутри ViewModel.
    private val _movies = MutableLiveData<List<Movie>>()

    // movies - это публичная, неизменяемая версия, на которую подписывается UI.
    val movies: LiveData<List<Movie>> = _movies

    init {
        // Загружаем данные при первом создании ViewModel
        // Проверяем, что данные еще не загружены, чтобы не делать это повторно.
        if (_movies.value == null) {
            _movies.value = MoviesDataSource.getMovies()
        }
    }
}


