package com.movies.http.controllers;

import com.movies.models.entities.Movie;
import com.movies.repositories.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){

        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> index(){
        return movieRepository.findAll();
    }
}
