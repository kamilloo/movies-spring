package com.movies.unit.http.controllers;

import com.movies.http.controllers.HelloController;
import com.movies.services.DashboardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest()
class HelloControllerTests {

	@Autowired
	private HelloController helloController;

	@MockBean
	private DashboardService service;

	@Test
	void contextLoaded()  {
		assertNotNull(helloController);
	}

	@Test
	void index_getHelloPage()  {
		String expectedHello = "Hello Mock";
		//WHEN
		when(service.dashboard()).thenReturn(expectedHello);
		String hello = helloController.index();

		//THEN
		verify(service, times(1)).dashboard();
		assertEquals(expectedHello, hello);
	}

}
