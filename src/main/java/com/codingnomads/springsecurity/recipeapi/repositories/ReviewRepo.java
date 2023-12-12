/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.recipeapi.repositories;

import com.codingnomads.springsecurity.recipeapi.models.Review;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    ArrayList<Review> findByUser_Username(String username);
}
