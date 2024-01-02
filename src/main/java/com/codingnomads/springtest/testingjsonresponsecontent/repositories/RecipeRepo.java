/* CodingNomads (C)2023 */
package com.codingnomads.springtest.testingjsonresponsecontent.repositories;

import com.codingnomads.springtest.testingjsonresponsecontent.models.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContaining(String name);
}
