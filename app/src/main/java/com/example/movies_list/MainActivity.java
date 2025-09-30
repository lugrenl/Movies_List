package com.example.movies_list;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private LinearLayout moviesGridContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        moviesGridContainer = findViewById(R.id.movies_grid_container);
        populateMoviesGrid();
    }

    private void populateMoviesGrid() {
        List<Movie> movies = getMovies();

        // Получаем все ряды
        LinearLayout row1 = (LinearLayout) moviesGridContainer.getChildAt(0);
        LinearLayout row2 = (LinearLayout) moviesGridContainer.getChildAt(1);
        LinearLayout row3 = (LinearLayout) moviesGridContainer.getChildAt(2);

        // Заполняем первый ряд
        fillCard((ViewGroup) row1.getChildAt(0), movies.get(0));
        fillCard((ViewGroup) row1.getChildAt(1), movies.get(1));

        // Заполняем второй ряд
        fillCard((ViewGroup) row2.getChildAt(0), movies.get(2));
        fillCard((ViewGroup) row2.getChildAt(1), movies.get(3));

        // Заполняем третий ряд
        fillCard((ViewGroup) row3.getChildAt(0), movies.get(4));
        fillCard((ViewGroup) row3.getChildAt(1), movies.get(5));
    }

    private void fillCard(ViewGroup card, Movie movie){
        ImageView poster = card.findViewById(R.id.movie_poster);
        TextView ageLimit = card.findViewById(R.id.age_limit);
        RatingBar rating = card.findViewById(R.id.movie_rating);
        TextView genre = card.findViewById(R.id.movie_genre);
        TextView title = card.findViewById(R.id.movie_title);

        poster.setImageResource(movie.getPoster());
        ageLimit.setText(movie.getAgeLimit());
        rating.setRating(movie.getRating());
        genre.setText(movie.getGenre());
        title.setText(movie.getTitle());

        card.setOnClickListener(v -> {
            Intent intent = new Intent(this, MovieDetailsActivity.class);
            intent.putExtra("movie", (Parcelable) movie);
            startActivity(intent);
        });
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(1, R.drawable.star_trek_picard, "16+", 3.0f, "Action, Adventure, Drama", "Star Trek: Picard"));
        movies.add(new Movie(2, R.drawable.the_mandalorian, "12+", 4.0f, "Action, Adventure, Fantasy", "The Mandalorian"));
        movies.add(new Movie(3, R.drawable.the_witcher, "14+", 5.0f, "Action, Adventure, Fantasy", "The Witcher"));
        movies.add(new Movie(4, R.drawable.joker, "18+", 4.0f, "Crime, Drama, Thriller", "Joker"));
        movies.add(new Movie(5, R.drawable.tenet, "18+", 3.0f, "Action, Sci-Fi", "Tenet"));
        movies.add(new Movie(6, R.drawable.altered_carbon, "12+", 5.0f, "Action, Drama, Sci-Fi", "Altered Carbon"));

        return movies;
    }
}