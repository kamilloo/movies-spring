package com.movies.services.movies;

import com.movies.models.entities.Movie;
import com.movies.models.entities.User;
import com.movies.repositories.MovieRepository;
import com.movies.repositories.OmdbRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    private final OmdbRepository omdbRepository;

    public MovieService(MovieRepository movieRepository, OmdbRepository omdbRepository){
        this.movieRepository = movieRepository;
        this.omdbRepository = omdbRepository;
    }

    public Optional<Movie> create(String title, User user){
        Optional<Movie> movie = omdbRepository.findByTitle(title);
        if (movie.isPresent()){
            movie.get().setUserId(user.getId());
            movieRepository.save(movie.get());
        }
        return movie;
    }
}
