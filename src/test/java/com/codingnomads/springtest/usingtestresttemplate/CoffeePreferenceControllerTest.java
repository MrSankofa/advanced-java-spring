/* CodingNomads (C)2023 */
package com.codingnomads.springtest.usingtestresttemplate;

import static org.assertj.core.api.Assertions.assertThat;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = UsingTestRestTemplateMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeePreferenceControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

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
        assertThat(Objects.requireNonNull(postedCoffeePreference.getBody()).getId())
                .isNotNull();
    }
}
