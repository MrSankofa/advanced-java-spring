/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.plantexample;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepo extends JpaRepository<Plant, Long> {

    //////////////// INTRODUCER VARIATIONS ////////////////

    List<Plant> findByName(String name);
    // select * from plant where name = $name;

    List<Plant> queryByName(String name);

    List<Plant> readByName(String name);

    List<Plant> getByName(String name);

    int countByNameIs(String name);

    //////////////// SIMILARITY KEYWORDS ////////////////

    // find all plants with names starting with namePrefix
    List<Plant> findByNameStartingWith(String namePrefix);

    // select * from plant where name like "**$namePrefix"

    // find all plants with names ending in nameSuffix
    List<Plant> findByNameEndingWith(String nameSuffix);

    // select * from plant where name like "$namePrefix**"

    // find all plants with names containing pattern
    List<Plant> findByNameContaining(String pattern);

    //////////////// EQUALITY KEYWORDS ////////////////

    // Using Is vs. findByName(String name)
    List<Plant> findByNameIs(String name);

    // IsNot
    List<Plant> findByNameIsNot(String name);

    // IsNull
    List<Plant> findBySunTypeIsNull();

    // IsNotNull
    List<Plant> findBySunTypeIsNotNull();

    // use IsTrue and IsFalse instead of findByFruitBearing(boolean fruitBearing);
    List<Plant> findByFruitBearingIsTrue(); // need to work boolean properties

    List<Plant> findByFruitBearingIsFalse();

    //////////////// MORE EQUALITY KEYWORDS ////////////////

    List<Plant> findByNumDaysTillRipeFruitLessThan(int numDays);

    List<Plant> findByNumDaysTillRipeFruitLessThanEqual(int numDays);

    List<Plant> findByNumDaysTillRipeFruitGreaterThan(int numDays);

    List<Plant> findByNumDaysTillRipeFruitGreaterThanEqual(int numDays);

    //////////////// NESTED PROPERTY CHARACTER ////////////////

    // find plants with a favorite soil type with pHs less than a passed in value
    List<Plant> findByFavoriteSoilType_phLessThan(long ph); // composite object properties

    // find plants who's favorite soil is dry
    List<Plant> findByFavoriteSoilType_dryIsTrue();

    // find plants with a certain soil type identified by its ID
    //    List<Plant> findByFavoriteSoilType_id(long soilTypeId);
    Optional<Plant> findByFavoriteSoilType_id(long soilTypeId);

    //////////////// LIMITING KEYWORDS ////////////////

    // find the first dry soil type plant
    Plant findFirstByFavoriteSoilType_dryIsTrue();

    Plant getTopByFavoriteSoilType_dryIsTrue();

    // find the last 5 plants based on soil type pH less than the passed in pH(unsorted)
    List<Plant> findLast5ByFavoriteSoilType_phLessThan(long ph);

    // find the first 20 plants based on soil type pH greater than or equal to the passed in pH(unsorted)
    List<Plant> findTop20ByFavoriteSoilType_phGreaterThanEqual(long ph);

    //////////////// DISTINCT KEYWORD ////////////////

    // distinct with no limit keyword
    List<Plant> findDistinctByFavoriteSoilType_phLessThan(long ph);

    // distinct before limit keyword
    /*
    * SELECT DISTINCT p.*
        FROM plant p
        JOIN favorite_soil_type f ON p.favorite_soil_type_id = f.id
        WHERE f.ph < :ph
        ORDER BY p.id DESC
        LIMIT 5;
    * */
    List<Plant> findDistinctLast5ByFavoriteSoilType_phLessThan(long ph);

    // distinct after limit keyword
    List<Plant> findLastDistinct5ByFavoriteSoilType_phLessThan(long ph);

    //////////////// PAGING AND SORTING ////////////////

    // search plant names containing a pattern on a page by page basis
    Page<Plant> findByNameContaining(String pattern, Pageable pageable);

    //////////////// MULTIPLE CONDITIONS ////////////////

    List<Plant> findByNameContainingAndFavoriteSoilType_Name(String partialPlantName, String soilTypeName);

    List<Plant> findByFruitBearingAndFavoriteSoilType_dry(boolean fruitBearing, boolean drySoil);
}
