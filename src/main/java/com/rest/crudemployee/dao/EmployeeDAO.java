package com.rest.crudemployee.dao;

import java.util.List;

import com.rest.crudemployee.entity.Employee;

public interface EmployeeDAO {
    
    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    Employee deleteById(int employeeId);

}
