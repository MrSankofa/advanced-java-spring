package com.codingnomads.springdata.example.dml.transactional.repositories;

import com.codingnomads.springdata.example.dml.transactional.models.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepo extends JpaRepository<Point, Long> {
}
