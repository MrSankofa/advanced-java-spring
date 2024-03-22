/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab_complete.repositories;

import com.codingnomads.springdata.lab_complete.models.PointOfInterest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {

    List<PointOfInterest> findAllByArea_code(String code);

    List<PointOfInterest> findAllDistinctByRoutes_codeContaining(String code);
}
