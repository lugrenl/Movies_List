package com.example.movies_list;

public class Actor {
    private int id;
    private int poster;
    private String name;

    public Actor(int id, int poster, String name) {
        this.id = id;
        this.poster = poster;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
