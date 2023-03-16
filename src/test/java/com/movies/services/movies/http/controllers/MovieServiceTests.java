package com.movies.services.movies.http.controllers;

import com.movies.http.controllers.HelloController;
import com.movies.models.entities.Movie;
import com.movies.models.entities.User;
import com.movies.repositories.MovieRepository;
import com.movies.repositories.OmdbRepository;
import com.movies.services.DashboardService;
import com.movies.services.movies.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest()
class MovieServiceTests {

	@Autowired
	private MovieService movieService;

	@MockBean
	private MovieRepository movieRepository;

	@MockBean
	private OmdbRepository omdbRepository;

	@Test
	void contextLoaded()  {
		assertNotNull(movieService);
	}

	@Test
	void create_whanMovieNotFound_notSavedLocally()  {
		//GIVEN
		String title = "Fake Title";
		//WHEN
		when(omdbRepository.findByTitle(title)).thenReturn(Optional.empty());
		Optional<Movie> saved = movieService.create(title, new User());

		//THEN
		verify(omdbRepository, times(1)).findByTitle(title);
		verify(movieRepository, times(0)).save(new Movie());
		assertTrue(saved.isEmpty());
	}


	@Test
	void create_whanMovieFound_SavedLocally()  {
		//GIVEN
		String title = "True Title";
		User user = new User();
		user.setId(1L);
		Movie movie = new Movie();
		movie.setTitle(title);
		//WHEN
		when(omdbRepository.findByTitle(title)).thenReturn(Optional.of(movie));
		when(movieRepository.save(movie)).thenReturn(movie);
		Optional<Movie> saved = movieService.create(title, user);

		//THEN
		verify(omdbRepository, times(1)).findByTitle(title);
		verify(movieRepository, times(1)).save(movie);
		assertEquals(title, saved.get().getTitle());
		assertEquals(1L, saved.get().getUserId());
	}

}
