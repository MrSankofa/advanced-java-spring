/* CodingNomads (C)2023 */
package com.codingnomads.cachingwithspring.demo;

import com.codingnomads.cachingwithspring.demo.model.Employee;
import com.codingnomads.cachingwithspring.demo.repository.EmployeeRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
            if (employeeRepository.findAll().isEmpty()) {
                employeeRepository.saveAllAndFlush(List.of(
                        new Employee("Cassandry Crumpton"),
                        new Employee("Orella Hedge"),
                        new Employee("Colby Ambroz"),
                        new Employee("Doug Loveguard"),
                        new Employee("Iosep O'Clery")));
            }
        };
    }
}
