package com.rest.crudemployee.service;

import java.util.List;

import com.rest.crudemployee.entity.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    Employee deleteById(int employeeId);
}

