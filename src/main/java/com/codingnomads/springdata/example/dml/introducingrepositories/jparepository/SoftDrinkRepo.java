/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.introducingrepositories.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftDrinkRepo extends JpaRepository<SoftDrink, Long> {}
