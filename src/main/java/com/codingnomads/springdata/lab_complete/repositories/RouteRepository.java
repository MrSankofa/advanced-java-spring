/* CodingNomads (C)2023 */
package com.codingnomads.springdata.lab_complete.repositories;

import com.codingnomads.springdata.lab_complete.models.Route;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> findByOrigin_code(String code);

    List<Route> findByDestination_code(String code);

    List<Route> findAllByCodeContaining(String code);

    Route findByCode(String code);
}
