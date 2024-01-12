/* CodingNomads (C)2024 */
package com.codingnomads.springtest.understandingandusingprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestDataLoader implements CommandLineRunner {

    @Autowired
    CoffeePreferenceRepo repo;

    @Override
    public void run(String... args) throws Exception {

        repo.save(CoffeePreference.builder()
                .type("Americano")
                .iced(true)
                .size(CoffeePreference.Size.LARGE)
                .intensity(7)
                .sugar(false)
                .build());

        repo.save(CoffeePreference.builder()
                .type("Espresso")
                .iced(false)
                .size(CoffeePreference.Size.SMALL)
                .intensity(4)
                .sugar(true)
                .build());
    }
}
