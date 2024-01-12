/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab_complete.repositories;

import com.codingnomads.springdata.lab_complete.models.Area;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Long> {

    Area findByCode(String code);

    List<Area> findAllByPointsOfInterest_typeIgnoreCase(String name);
}
