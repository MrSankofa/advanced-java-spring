package com.codingnomads.springsecurity.authentication.usernamepassword.repositories;

import com.codingnomads.springsecurity.authentication.usernamepassword.models.UserPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPrincipalRepo extends JpaRepository<UserPrincipal, Long> {
    Optional<UserPrincipal> findByUsername(String username);
}
