/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation;

import com.codingnomads.springdata.example.dml.usingqueryannotation.services.PlantService;
import com.codingnomads.springdata.example.dml.usingqueryannotation.services.SoilTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class);
    }

    @Autowired
    PlantService plantService;

    @Autowired
    SoilTypeService soilTypeService;

    @Override
    public void run(String... args) throws Exception {

        plantService.saveStuff();

        plantService.getStuff();

        soilTypeService.findSoilTypeByName("tester");
        soilTypeService.findByPhLessThan(8);
//        soilTypeService.findDrySoilTypes();
        soilTypeService.findByPhLessThanAndPhGreaterThan(7.2, 7.5);
        soilTypeService.findByNameLike("tester");
    }
}
