package com.hihusky.springdatarestdemo.repository;


import com.hihusky.springdatarestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
