package com.codingnomads.springsecurity.authorization.addingauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingnomads.springsecurity.authorization.addingauthorization.models.Authority;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, Long> {
}