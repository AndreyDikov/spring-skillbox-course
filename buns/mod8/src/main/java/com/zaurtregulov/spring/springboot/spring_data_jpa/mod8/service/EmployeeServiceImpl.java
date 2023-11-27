package com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.service;

import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
