package com.movies.functional.http.controllers.movieController.index;

import com.google.gson.Gson;
import com.movies.models.entities.Movie;
import com.movies.repositories.MovieRepository;
import jakarta.persistence.Column;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MovieRepository movieRepository;

	@BeforeEach
	public void setUp(){
		movieRepository.deleteAll();
	}

	@Test
	void index_getMoviesList() throws Exception  {
		//GIVEN
		String name = "name";
		String director = "director";
		String title = "title";
		String genre = "genre";
		LocalDate released = LocalDate.of(2000,01,01);

		Movie movie = Movie.builder()
				.title(title)
				.name(name)
				.director(director)
				.genre(genre)
				.released(released)
				.userId(1L)
				.build();
		movieRepository.save(movie);

		Gson content = new Gson();
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("Name", name);
		expected.put("Director", director);
		expected.put("Title", title);
		expected.put("Genre", genre);
		expected.put("Released", "2000-01-01");

		String payload = content.toJson(expected);

		var response = mvc.perform(MockMvcRequestBuilders.get("/movies")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(String.format("[%s]", payload)));
	}

}
