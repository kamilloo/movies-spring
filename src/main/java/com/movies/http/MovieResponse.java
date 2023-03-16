package com.movies.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movies.models.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MovieResponse {

    @JsonProperty("Released")
    private final LocalDate released;
    @JsonProperty("Director")
    private final String director;
    @JsonProperty("Name")
    private final String name;
    @JsonProperty("Genre")
    private final String genre;
    @JsonProperty("Title")
    private final String title;


    public MovieResponse(Movie movie){
        this.name = movie.getName();
        this.director = movie.getDirector();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.released = movie.getReleased();
    }
}

