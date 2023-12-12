/* CodingNomads (C)2023 */
package com.codingnomads.cachingwithspring.demo.repository;

import com.codingnomads.cachingwithspring.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
