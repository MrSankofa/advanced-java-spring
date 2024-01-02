/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.commonproblems.repositories;

import com.codingnomads.springdata.example.dml.commonproblems.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String name);

    List<User> findByAddress_id(Long id);
}
