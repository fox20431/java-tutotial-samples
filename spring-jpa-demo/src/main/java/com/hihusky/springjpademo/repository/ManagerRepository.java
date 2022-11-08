package com.hihusky.springjpademo.repository;

import com.hihusky.springjpademo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
