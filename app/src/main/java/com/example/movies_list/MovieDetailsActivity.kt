package com.example.movies_list;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailsActivity extends AppCompatActivity {

    private LinearLayout actorsGridContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        actorsGridContainer = findViewById(R.id.actors_grid_container);
        populateActorsGrid();

        // Получаем данные о фильме
        Movie movie = getIntent().getParcelableExtra("movie");
        if (movie != null) {
            setupMovieDetails(movie);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setupMovieDetails(Movie movie) {
        ImageView poster = findViewById(R.id.movie_poster_details);
        TextView ageLimit = findViewById(R.id.age_limit_details);
        TextView title = findViewById(R.id.movie_title_details);
        RatingBar rating = findViewById(R.id.movie_rating_details);
        TextView genre = findViewById(R.id.movie_genre_details);
        TextView storyLine = findViewById(R.id.storyline_text_details);

        poster.setImageResource(movie.getPoster());
        ageLimit.setText(movie.getAgeLimit());
        title.setText(movie.getTitle());
        rating.setRating(movie.getRating());
        genre.setText(movie.getGenre());
        storyLine.setText("Это хороший фильм с интересным сюжетом, не даром его назвали " + movie.getTitle());
    }

    private void populateActorsGrid() {
        List<Actor> actors = getActors();

        // Заполняем ряд
        fillCard((ViewGroup) actorsGridContainer.getChildAt(0), actors.get(0));
        fillCard((ViewGroup) actorsGridContainer.getChildAt(1), actors.get(1));
        fillCard((ViewGroup) actorsGridContainer.getChildAt(2), actors.get(2));
        fillCard((ViewGroup) actorsGridContainer.getChildAt(3), actors.get(3));
        fillCard((ViewGroup) actorsGridContainer.getChildAt(4), actors.get(4));
        fillCard((ViewGroup) actorsGridContainer.getChildAt(5), actors.get(5));
    }

    private void fillCard(ViewGroup card, Actor actor){
        ImageView poster = card.findViewById(R.id.actor_poster);
        TextView actorName = card.findViewById(R.id.actor_name);

        poster.setImageResource(actor.getPoster());
        actorName.setText(actor.getName());
    }

    private List<Actor> getActors() {
        List<Actor> actors = new ArrayList<>();

        actors.add(new Actor(1, R.drawable.carl_weathers, "Carl Weathers"));
        actors.add(new Actor(2, R.drawable.chris_bartlett, "Chris Bartlett"));
        actors.add(new Actor(3, R.drawable.gina_carano, "Gina Carano"));
        actors.add(new Actor(4, R.drawable.misty_rosas, "Misty Rosas"));
        actors.add(new Actor(5, R.drawable.pedro_pascal, "Pedro Pascal"));
        actors.add(new Actor(6, R.drawable.rio_hackford, "Rio Hackford"));

        return actors;
    }
}
