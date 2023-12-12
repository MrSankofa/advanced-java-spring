package com.codingnomads.springdata.example.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingnomads.springdata.example.querydsl.models.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>, AreaCustomRepository {

}
