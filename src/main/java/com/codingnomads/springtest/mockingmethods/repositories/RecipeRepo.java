/* CodingNomads (C)2023 */
package com.codingnomads.springtest.mockingmethods.repositories;

import com.codingnomads.springtest.mockingmethods.models.Recipe;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    ArrayList<Recipe> findByNameContaining(String name);
}
