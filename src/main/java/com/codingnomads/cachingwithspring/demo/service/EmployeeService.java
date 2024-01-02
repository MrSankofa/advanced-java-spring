/* CodingNomads (C)2023 */
package com.codingnomads.cachingwithspring.demo.service;

import com.codingnomads.cachingwithspring.demo.exception.ResourceNotFoundException;
import com.codingnomads.cachingwithspring.demo.model.Employee;
import com.codingnomads.cachingwithspring.demo.repository.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // can be used to inspect the cache during debug
    @Autowired
    CacheManager cacheManager;

    @Cacheable(value = "employees", key = "#employeeId", sync = true)
    public Employee getEmployee(Integer employeeId) {

        fakeDelay("Fetching employee from the database...");

        return employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + employeeId));
    }

    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        fakeDelay("Fetching all employees from the database...");
        return employeeRepository.findAll();
    }

    @CachePut(value = "employees", key = "#employee.id")
    public Employee saveEmployee(Employee employee) {
        System.out.println("Saving employee to the database and updating cache");
        return employeeRepository.save(employee);
    }

    @CacheEvict(value = "employees", allEntries = true)
    public void deleteEmployee(Integer employeeId) {
        System.out.println("Removing all employees from the database and cache");
        employeeRepository.deleteById(employeeId);
    }

    public void fakeDelay(String message) {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
