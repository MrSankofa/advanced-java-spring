/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.querydsl.repository;

import com.codingnomads.springdata.example.querydsl.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long>, AreaCustomRepository {}
