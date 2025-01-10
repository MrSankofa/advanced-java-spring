/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation.repositories;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.repository.query.Param;


@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {


//  @Query(value = "select s from SoilType where name = ?1", nativeQuery = true)
  @Query("select s from SoilType s where s.name = ?1")
  SoilType findByName(String name);

  // find soilType where the ph is less than 4
  @Query("select s from SoilType s where s.ph < ?1")
  List<SoilType> findByPhLessThan(double amount);

  // find soilType where the soilType is dry
  @Query("select s from SoilType s where s.dry = true")
  SoilType findDrySoilTypes();

  // find soilType where the ph is between 3 - 5
  @Query("select s from SoilType s where s.ph <= ?2 and s.ph >= ?1")
  SoilType findByPhLessThanAndPhGreaterThan(double min, double max);

  // find soil type that starts with
  @Query("select s from SoilType s where s.name like CONCAT(:name, '%')")
  List<SoilType> findByNameLike(@Param("name") String name);
}
