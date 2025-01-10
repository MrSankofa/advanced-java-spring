package com.codingnomads.springdata.example.dml.usingqueryannotation.services;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import com.codingnomads.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoilTypeService {

  @Autowired
  SoilTypeRepo soilTypeRepo;

  // what is the transactional annotation for?
  @Transactional
  public void findSoilTypeByName(String name) {
    SoilType result = soilTypeRepo.findByName(name);
  }
  @Transactional
  public void findByPhLessThan(double amount) {
    List<SoilType> result1 = soilTypeRepo.findByPhLessThan(amount);


    System.out.println("This is the findByPhLessThan result: " + result1);

  }
  @Transactional
  public void findDrySoilTypes() {

    SoilType result2 = soilTypeRepo.findDrySoilTypes();



    System.out.println("This is the findDrySoilTypes result: " + result2);
  }
  @Transactional
  public void findByPhLessThanAndPhGreaterThan(double min, double max) {

    SoilType result3 = soilTypeRepo.findByPhLessThanAndPhGreaterThan(min, max);


    System.out.println("This is the findByPhLessThanAndPhGreaterThan result: " + result3);

  }
  @Transactional
  public void findByNameLike(String name) {

    List<SoilType> result4 = soilTypeRepo.findByNameLike("test");
    System.out.println("This is the findByNameLike result: " + result4);
  }
}
