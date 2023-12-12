/* CodingNomads (C)2023 */
package com.codingnomads.springtest.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMoviesSuccess() {}

    @Test
    public void testGetAllMoviesFailure() {}

    @Test
    public void testGetAllMoviesSuccessMockService() {}
}
