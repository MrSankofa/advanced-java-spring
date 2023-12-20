/* CodingNomads (C)2023 */
package com.codingnomads.springtest.mockingmethods.repositories;

import com.codingnomads.springtest.mockingmethods.models.Review;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByUsername(String username);
}
