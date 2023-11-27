package com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> getAllEmployeesByName(String name);
}
