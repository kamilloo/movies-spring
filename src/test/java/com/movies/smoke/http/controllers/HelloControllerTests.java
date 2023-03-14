package com.movies.smoke.http.controllers;

import com.movies.http.controllers.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloControllerTests {

	@Autowired
	private HelloController helloController;

	@Test
	void index_getHelloPage()  {
		assertNotNull(helloController);
	}

}
