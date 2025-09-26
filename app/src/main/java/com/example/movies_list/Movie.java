package com.example.movies_list;

public class Movie {
    private int id;
    private int poster;
    private String ageLimit;
    private float rating;
    private String genre;
    private String title;

    public Movie(int id, int poster, String ageLimit, float rating, String genre, String title) {
        this.id = id;
        this.poster = poster;
        this.ageLimit = ageLimit;
        this.rating = rating;
        this.genre = genre;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
