package com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.dao;

import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);
}
