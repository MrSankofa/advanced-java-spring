package com.codingnomads.springdata.example.dml.commonproblems.repositories;

import com.codingnomads.springdata.example.dml.commonproblems.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String name);

    ArrayList<User> findByAddress_id(Long id);
}
