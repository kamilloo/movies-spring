package com.movies.services.movies.MoviesApi;

import com.movies.models.entities.Movie;
import com.movies.repositories.OmdbRepository;

import java.util.Optional;

public class OmdbRepositoryImpl implements OmdbRepository {

    private final OmdbApi movieApi;

    public OmdbRepositoryImpl(OmdbApi movieApi){

        this.movieApi = movieApi;
    }
    @Override
    public Optional<Movie> findByTitle(String title) {

        return Optional.empty();
    }
}
