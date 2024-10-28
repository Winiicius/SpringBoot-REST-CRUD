package com.rest.crudemployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.crudemployee.entity.Employee;
import com.rest.crudemployee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {

        Optional<Employee> employeeList =  employeeRepository.findById(employeeId);

        Employee employee = null;

        if (employeeList.isPresent()) {
            employee = employeeList.get();
        }else{
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }
        return employee;
    }

    @Override
    public Employee deleteById(int employeeId) {

        Employee employee = findById(employeeId);

        employeeRepository.deleteById(employeeId);

        return employee;

    }


}
