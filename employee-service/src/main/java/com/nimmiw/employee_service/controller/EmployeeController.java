package com.nimmiw.employee_service.controller;

import com.nimmiw.employee_service.model.Employee;
import com.nimmiw.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.getEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.getEmployee(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }
}
