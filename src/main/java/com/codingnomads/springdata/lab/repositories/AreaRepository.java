package com.codingnomads.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springdata.lab.models.Area;

public interface AreaRepository extends JpaRepository<Area,Long> {

}
