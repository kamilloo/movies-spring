package com.movies.services.movies.MoviesApi;

import com.movies.http.MovieResponse;
import com.movies.models.entities.Movie;
import com.movies.repositories.OmdbRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class OmdbRepositoryImpl implements OmdbRepository {

    private final OmdbApi movieApi;

    public OmdbRepositoryImpl(OmdbApi movieApi){

        this.movieApi = movieApi;
    }
    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieApi.findByTitle(title)
                .map(value -> new Movie(value))
                .orElseGet(() ->  Optional.empty());
    }
}
