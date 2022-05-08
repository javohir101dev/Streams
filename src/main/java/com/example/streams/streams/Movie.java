package com.example.streams.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Comparator;

@AllArgsConstructor
@Getter
@ToString
public class Movie implements Comparable<Movie>{

    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    @Override
    public int compareTo(Movie o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
