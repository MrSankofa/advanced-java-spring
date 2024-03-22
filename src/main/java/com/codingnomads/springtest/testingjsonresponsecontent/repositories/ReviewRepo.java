/* CodingNomads (C)2024 */
package com.codingnomads.springtest.testingjsonresponsecontent.repositories;

import com.codingnomads.springtest.testingjsonresponsecontent.models.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByUsername(String username);
}
