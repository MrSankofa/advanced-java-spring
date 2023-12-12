/* CodingNomads (C)2023 */
package com.codingnomads.aspectorientedprogramming.lab;

import com.codingnomads.aspectorientedprogramming.lab.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class AOPLab implements CommandLineRunner {

    public final GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(AOPLab.class);
    }

    @Override
    public void run(String... args) throws Exception {
        greetingService.greeting();
    }
}
