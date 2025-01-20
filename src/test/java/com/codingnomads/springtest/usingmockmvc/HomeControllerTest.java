/* CodingNomads (C)2025 */
package com.codingnomads.springtest.usingmockmvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class) // Load only the controller and its dependencies
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void index() throws Exception {
        // Test the "/" endpoint
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // Check HTTP status 200
                .andExpect(view().name("greeting")) // Check the view name
                .andExpect(model().attribute("name", "Bobbert")); // Check the model attribute
    }

    @Test
    void greet() {}
}
