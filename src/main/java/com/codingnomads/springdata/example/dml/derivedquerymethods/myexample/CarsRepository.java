package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars, Long> {

  List<Cars> findByMake(String make);

  List<Cars> findByModel(String model);

  List<Cars> findByYear(int year);

  List<Cars> findByYearAndMake(String year, String make);

  List<Cars> findByYearAndMakeAndModel(String year, String make, String model);

  List<Cars> findByMakeAndModel(String make, String model);

  List<Cars> findByMakeAndYear(String make, int year);
}
