package com.codingnomads.springdata.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springdata.example.jpa.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {
}

