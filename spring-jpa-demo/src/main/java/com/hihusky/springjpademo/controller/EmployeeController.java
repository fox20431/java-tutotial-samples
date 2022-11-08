package com.hihusky.springjpademo.controller;

import com.hihusky.springjpademo.entity.Employee;
import com.hihusky.springjpademo.entity.Manager;
import com.hihusky.springjpademo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> show() {
        return employeeRepository.findAll();
    }
}
