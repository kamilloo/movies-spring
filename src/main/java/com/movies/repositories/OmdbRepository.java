package com.movies.repositories;

import com.movies.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OmdbRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTile(String title);
}
