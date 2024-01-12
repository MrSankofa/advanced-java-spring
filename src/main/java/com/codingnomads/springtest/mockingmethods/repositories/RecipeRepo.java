/* CodingNomads (C)2024 */
package com.codingnomads.springtest.mockingmethods.repositories;

import com.codingnomads.springtest.mockingmethods.models.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    List<Recipe> findByNameContaining(String name);
}
