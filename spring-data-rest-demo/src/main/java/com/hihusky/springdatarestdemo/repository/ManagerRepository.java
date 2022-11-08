package com.hihusky.springdatarestdemo.repository;

import com.hihusky.springdatarestdemo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
