package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
