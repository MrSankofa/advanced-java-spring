/* CodingNomads (C)2025 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {

    List<Cars> findByMake(String make);

    List<Cars> findByModel(String model);

    List<Cars> findByYear(int year);

    List<Cars> findByYearAndMake(String year, String make);

    List<Cars> findByYearAndMakeAndModel(String year, String make, String model);

    List<Cars> findByMakeAndModel(String make, String model);

    List<Cars> findByMakeAndYear(String make, int year);
}
