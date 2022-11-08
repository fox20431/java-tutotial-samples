package com.hihusky.springdatarestdemo;

import com.hihusky.springdatarestdemo.entity.Employee;
import com.hihusky.springdatarestdemo.entity.Manager;
import com.hihusky.springdatarestdemo.repository.EmployeeRepository;
import com.hihusky.springdatarestdemo.repository.ManagerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestDemoApplication.class, args);
    }

    @PostConstruct
    void test() {
        System.out.println("loading servlet");
    }

    @Bean
    CommandLineRunner init(ManagerRepository managerRepository, EmployeeRepository employeeRepository) {
        return args -> {
            Manager nina = managerRepository.save(Manager.builder().firstName("Nina").lastName("Adkins").build());
            Employee nicholas = employeeRepository.save(Employee.builder().firstName("Nicholas").lastName("Copernicus").manager(nina).build());
            Employee albert = employeeRepository.save(Employee.builder().firstName("Albert").lastName("Einstein").manager(nina).build());

            Manager maximilian = managerRepository.save(Manager.builder().firstName("Maximilian").lastName("Dolan").build());
            Employee galileo = employeeRepository.save(Employee.builder().firstName("Galileo").lastName("Currie").manager(maximilian).build());

            Manager matthias = managerRepository.save(Manager.builder().firstName("Matthias").lastName("Rios").build());
            Employee marie = employeeRepository.save(Employee.builder().firstName("Marie").lastName("Olsen").manager(matthias).build());
            Employee max = employeeRepository.save(Employee.builder().firstName("Max").lastName("Planck").manager(matthias).build());
            Employee maliha = employeeRepository.save(Employee.builder().firstName("Maliha").lastName("Donnelly").manager(matthias).build());
        };
    }
}
