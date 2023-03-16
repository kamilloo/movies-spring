package com.movies.functional.http.controllers.movieController.store;

import com.google.gson.Gson;
import com.movies.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MovieRepository movieRepository;

	Gson content;

	@BeforeEach
	public void setUp(){
		movieRepository.deleteAll();
		content = new Gson();
	}

	@Test
	void store_createNewMovie() throws Exception  {

		//GIVEN
		String title = "matrix";
		Map<String, String> payload = new HashMap<>();
		payload.put("title", title);

		Map<String, String> expected = new HashMap<>();
		expected.put("Title", title);

		//WHEN
		mvc.perform(MockMvcRequestBuilders.post("/movies")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content.toJson(payload))
				.accept(MediaType.APPLICATION_JSON))
				//THEN
				.andExpect(status().isCreated())
				.andExpect(content().json(content.toJson(expected)));

		assertEquals(1, movieRepository.count());

	}

}
