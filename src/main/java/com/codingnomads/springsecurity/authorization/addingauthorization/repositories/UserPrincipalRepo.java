/* CodingNomads (C)2023 */
package com.codingnomads.springsecurity.authorization.addingauthorization.repositories;

import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserPrincipal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrincipalRepo extends JpaRepository<UserPrincipal, Long> {
    Optional<UserPrincipal> findByUsername(String username);
}
