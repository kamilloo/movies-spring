package com.movies.services.movies.MoviesApi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movies.models.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Getter
public class OmdbMovie {

    private final String title;
    private final String released;
    private final String genre;
    private final String director;

    public OmdbMovie(String title, String released, String genre, String director){
        this.title = title;
        this.released = released;
        this.genre = genre;
        this.director = director;
    }
}
