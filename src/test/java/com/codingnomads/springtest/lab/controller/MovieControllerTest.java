package com.codingnomads.springtest.lab.controller;


import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.repository.MovieRepository;
import com.codingnomads.springtest.lab.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;


import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
@ActiveProfiles("test")
@WithMockUser(username = "testuser", roles = {"USER"})
class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private MovieService movieService; // Mock the service, not the controller

  @MockBean
  private MovieRepository movieRepository; // Mock the repository

  @Test
  void getAllMovies() throws Exception {
    List<Movie> movies = new ArrayList<>();

    movies.add(Movie.builder().name("Looper").rating(10.0).build());

    Mockito.when(movieRepository.findAll()).thenReturn(movies);

    Mockito.when(movieService.getAllMovies()).thenReturn(movies);

    // $ is the response, the rest you can manipulate like normal java
    // Simulate HTTP GET request and validate the response
    mockMvc.perform(get("/all"))
        .andDo(print())
        .andExpect(status().isOk()) // Assert that the status is 200 OK
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("$[0].name").value("Looper"))
        .andExpect(jsonPath("$[0].rating").value(10.0));
  }
}