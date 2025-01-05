package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;


@WebMvcTest(DemoApplication.class)
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testGetList() throws Exception {
		mockMvc.perform(get("/list"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.size()", is(0)));
	}

	@Test
	public void testAddItem() throws Exception {
		Todo newTodo = new Todo(3, "Test the POST endpoint");
		mockMvc.perform(post("/list")
				.content(objectMapper.writeValueAsString(newTodo)).contentType(MediaType.APPLICATION_JSON)) // Convert object to JSON
                .andExpect(status().isOk()); // Expect HTTP 201 Created status
	}

}
