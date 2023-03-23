package com.movies.http.controllers;

import com.movies.http.MovieResponse;
import com.movies.http.requests.CreateMovieRequest;
import com.movies.models.entities.Movie;
import com.movies.models.entities.User;
import com.movies.repositories.MovieRepository;
import com.movies.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    public MovieController(MovieService movieService, MovieRepository movieRepository){
        this.movieService = movieService;
        this.movieRepository = movieRepository;
    }




    @GetMapping(value = "/movies")
    public ResponseEntity<List<MovieResponse>> index(@RequestAttribute User user){
        List<Movie> movies = movieRepository.findByUserId(user.getId());
        return ResponseEntity.ok(movies.stream().map(MovieResponse::new).collect(Collectors.toList()));
    }


    @PostMapping(value = "/movies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<MovieResponse> store(@RequestBody CreateMovieRequest request, @RequestAttribute User user)
    throws HttpClientErrorException.NotFound {
        Optional<Movie> movie = movieService.create(request.getTitle(), user);
        return movie.map(value -> ResponseEntity.status(201)
                .body(new MovieResponse(value)))
                .orElseGet(() ->  ResponseEntity.status(404).build());

    }
}
