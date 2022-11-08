package com.hihusky.springjpademo.controller;

import com.hihusky.springjpademo.entity.Manager;
import com.hihusky.springjpademo.repository.ManagerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerRepository managerRepository;

    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers")
    public List<Manager> show() {
        return managerRepository.findAll();
    }

    @PostMapping("/managers")
    public void add(@RequestBody Manager manager) {
        managerRepository.save(manager);
    }

}
