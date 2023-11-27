package com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.controllers;

import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.entity.Employee;
import com.zaurtregulov.spring.springboot.spring_data_jpa.mod8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getAllEmployeesByName(@PathVariable String name) {
        return employeeService.getAllEmployeesByName(name);
    }
}
