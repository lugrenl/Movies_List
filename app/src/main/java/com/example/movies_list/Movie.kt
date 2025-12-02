package com.example.movies_list;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
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

    protected Movie(Parcel in) {
        id = in.readInt();
        poster = in.readInt();
        ageLimit = in.readString();
        rating = in.readFloat();
        genre = in.readString();
        title = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // Геттеры
    public int getId() { return id; }
    public int getPoster() { return poster; }
    public String getAgeLimit() { return ageLimit; }
    public float getRating() { return rating; }
    public String getGenre() { return genre; }
    public String getTitle() { return title; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(poster);
        dest.writeString(ageLimit);
        dest.writeFloat(rating);
        dest.writeString(genre);
        dest.writeString(title);
    }
}