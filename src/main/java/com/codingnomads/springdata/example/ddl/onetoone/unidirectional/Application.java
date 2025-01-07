/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner testRunner(CarRepository carRepository) {
        return args -> {
            Car car = new Car();
            car.setBrand("Toyota");
            car.setHorsepower("200");
            carRepository.save(car);
        };
    }
}
