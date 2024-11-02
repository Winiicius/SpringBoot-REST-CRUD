package com.rest.crudemployee.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.crudemployee.entity.Employee;
import com.rest.crudemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    @PreAuthorize("hasRole('EMPLOYEE')")
    public Employee findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    @PreAuthorize("hasRole('MANAGER')")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    @PreAuthorize("hasRole('MANAGER')")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee deleteById(@PathVariable int employeeId){
        return employeeService.deleteById(employeeId);
    }
}
