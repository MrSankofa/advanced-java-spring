package com.codingnomads.springdata.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springdata.example.jpa.domain.CodeWarrior;

public interface CodeWarriorRepository extends JpaRepository<CodeWarrior,Long> {
}
