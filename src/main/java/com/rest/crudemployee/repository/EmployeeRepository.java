package com.rest.crudemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.crudemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Nothing here
    
}