package com.codingnomads.springdata.example.moderndatabaseintegration.jpa;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;

@SpringBootApplication
public class SpringDataJPAExample implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPAExample.class);
    }

    @Override
    public void run(String... args) {
        employeeRepository.findAll()
                .forEach(employee -> System.out.println(employee.toString()));
    }
}

@Entity
@Getter
@Setter
@ToString
class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
}

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

