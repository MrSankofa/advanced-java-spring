/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate;

import static org.assertj.core.api.Assertions.assertThat;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import java.util.Objects;

import com.codingnomads.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;
import com.codingnomads.springtest.usingtestresttemplate.services.CoffeePreferenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = UsingTestRestTemplateMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeePreferenceControllerTest {

    @Autowired
    CoffeePreferenceService coffeePreferenceService;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CoffeePreferenceRepo coffeePreferenceRepo;

    @BeforeEach
    public void setUp() {

        coffeePreferenceRepo.deleteAll();

        CoffeePreference coffeePreference = new CoffeePreference();
        coffeePreference.setIced(true);
        coffeePreference.setId(1L);
        coffeePreference.setIntensity(1);
        coffeePreference.setSize(CoffeePreference.Size.LARGE);
        coffeePreference.setSugar(true);
        coffeePreference.setType("Mocha");

        coffeePreferenceService.insertNewCoffeePreference(coffeePreference);
    }

    @Test
    public void testPostCoffeePreference() throws Exception {

        // build new CoffeePreference to post
        CoffeePreference preferenceToPost = CoffeePreference.builder()
                .type("Black")
                .size(CoffeePreference.Size.LARGE)
                .sugar(false)
                .iced(true)
                .intensity(9)
                .build();

        // send POST request using TestRestTemplate
        ResponseEntity<CoffeePreference> postedCoffeePreference =
                testRestTemplate.postForEntity("/coffee", preferenceToPost, CoffeePreference.class);

        // confirm Location header is correct
        String locationHeader = Objects.requireNonNull(
                        postedCoffeePreference.getHeaders().getLocation())
                .toString();
        assertThat(locationHeader).isEqualTo("http://www.url.com/new/location");

        // confirm ID was assigned
        assertThat(Objects.requireNonNull(postedCoffeePreference.getBody()).getId()).isNotNull();
    }

    @Test
    public void testGetCoffeePreferences() throws Exception {
        // Act: Call the endpoint
        ResponseEntity<CoffeePreference[]> response =
            testRestTemplate.getForEntity("/coffee/preferences", CoffeePreference[].class);

        // Assert: Validate the response status code
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Assert: Validate the response body is not null
        CoffeePreference[] preferences = response.getBody();
        assertThat(preferences).isNotNull();
        assertThat(preferences.length).isGreaterThan(0); // Ensure the array is not empty

        // Assert: Validate specific fields (if applicable)
        CoffeePreference firstPreference = preferences[0];
        assertThat(firstPreference.getType()).isNotEmpty();
        assertThat(firstPreference.getIntensity()).isBetween(0, 10);
        assertThat(firstPreference.getSize()).isNotNull();
    }
}
