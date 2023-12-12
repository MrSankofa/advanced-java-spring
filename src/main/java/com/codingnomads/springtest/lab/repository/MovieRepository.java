package com.codingnomads.springtest.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springtest.lab.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
