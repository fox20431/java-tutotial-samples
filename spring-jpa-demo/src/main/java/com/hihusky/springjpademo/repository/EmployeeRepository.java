package com.hihusky.springjpademo.repository;


import com.hihusky.springjpademo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
