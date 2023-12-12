package com.codingnomads.aspectorientedprogramming.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingnomads.aspectorientedprogramming.aop.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
