package com.codingnomads.springsecurity.authorization.addingauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserMeta;

@Repository
public interface UserMetaRepo extends JpaRepository<UserMeta, Long> {
}
