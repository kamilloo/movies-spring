package com.movies.http.controllers;

import com.movies.http.MovieResponse;
import com.movies.http.requests.CreateMovieRequest;
import com.movies.models.entities.Movie;
import com.movies.models.entities.User;
import com.movies.repositories.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){

        this.movieRepository = movieRepository;
    }

    @GetMapping(value = "/movies", consumes = "application/json")
    public ResponseEntity<List<MovieResponse>> index(@RequestAttribute User user){
        List<Movie> movies = movieRepository.findByUserId(user.getId());
        return ResponseEntity.ok(movies.stream().map(MovieResponse::new).collect(Collectors.toList()));
    }


    @PostMapping(value = "/movies", consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<MovieResponse> store(@RequestBody CreateMovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        Movie saved = movieRepository.save(movie);
        return ResponseEntity.status(201).body(new MovieResponse(saved));
    }
}
