package com.movies.http.controllers;

import com.movies.http.requests.CreateMovieRequest;
import com.movies.models.entities.Movie;
import com.movies.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/movies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Movie store(@RequestBody CreateMovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        Movie saved = movieRepository.save(movie);
        return saved;
    }
}
