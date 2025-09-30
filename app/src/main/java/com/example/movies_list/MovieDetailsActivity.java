package com.example.movies_list;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        // Получаем данные о фильме
        Movie movie = getIntent().getParcelableExtra("movie");
        if (movie != null) {
            setupMovieDetails(movie);
        }
    }

    private void setupMovieDetails(Movie movie) {
        ImageView poster = findViewById(R.id.movie_poster_details);
        TextView ageLimit = findViewById(R.id.age_limit_details);
        TextView title = findViewById(R.id.movie_title_details);
        RatingBar rating = findViewById(R.id.movie_rating_details);
        TextView genre = findViewById(R.id.movie_genre_details);

        poster.setImageResource(movie.getPoster());
        ageLimit.setText(movie.getAgeLimit());
        title.setText(movie.getTitle());
        rating.setRating(movie.getRating());
        genre.setText(movie.getGenre());
    }
}