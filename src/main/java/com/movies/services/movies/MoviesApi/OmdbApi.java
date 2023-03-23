package com.movies.services.movies.MoviesApi;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.movies.models.entities.Movie;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.stream.Stream;

public class OmdbApi {

    private String url = "https://www.omdbapi.com";

    @Value("${omdb.apiKey}")
    private String apiKey;

    private String search = "t";

    public OmdbApi(){
    }
    public Optional<OmdbMovie> findByTitle(String title) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest
                .newBuilder(new URI(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200){
            JsonObject raw = JsonParser.parseString(response.body()).getAsJsonObject();
            return Optional.of(new OmdbMovie(
                            raw.get("Title").getAsString(),
                            raw.get("Released").getAsString(),
                            raw.get("Genre").getAsString(),
                            raw.get("Director").getAsString()));
        }

        return Optional.empty();
    }
}
