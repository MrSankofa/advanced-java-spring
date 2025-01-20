/* CodingNomads (C)2025 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class Application {
    public static void main(String[] args) {}

    @Bean
    CommandLineRunner testRunner(CarsRepository carRepository) {
        return args -> {
            Cars car = new Cars();
            car.builder().make("Toyota").model("Supra").year(1996).build();
            Cars car1 = new Cars();
            car1.builder().make("Toyota").model("Corolla").year(1996).build();
            Cars car2 = new Cars();
            car2.builder().make("Toyota").model("Tacoma").year(1996).build();
            Cars car3 = new Cars();
            car3.builder().make("Toyota").model("Tundra").year(1996).build();
            Cars car4 = new Cars();
            car4.builder().make("Toyota").model("sedan").year(1996).build();
            carRepository.save(car);
            carRepository.save(car1);
            carRepository.save(car2);
            carRepository.save(car3);
            carRepository.save(car4);
        };
    }
}
