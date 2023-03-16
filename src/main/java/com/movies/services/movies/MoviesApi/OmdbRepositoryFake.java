package com.movies.services.movies.MoviesApi;

import com.movies.models.entities.Movie;
import com.movies.repositories.OmdbRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class OmdbRepositoryFake implements OmdbRepository {

    @Override
    public Optional<Movie> findByTitle(String title) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setName("name");
        movie.setGenre("genre");
        movie.setDirector("director");
        movie.setReleased(LocalDate.now());
        return Optional.of(movie);
    }
}
