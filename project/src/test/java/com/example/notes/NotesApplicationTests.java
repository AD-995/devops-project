package com.example.notes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NotesController.class)
class NotesControllerTests {

	@Autowired 
	private MockMvc mockMvc;

	@Test 
	void greetingTest() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Hello"));
	}

	@Test 
	void healthzTest() throws Exception {
		mockMvc.perform(get("/healthz")).andExpect(status().isOk()).andExpect(content().string("OK"));
	}

	@Test
	void listTest() throws Exception {
		mockMvc.perform(get("/notes")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(3))
			.andExpect(jsonPath("$[0]").value("Note 1"))
			.andExpect(jsonPath("$[1]").value("Note 2"))
			.andExpect(jsonPath("$[2]").value("Note 3"));
	}

}
