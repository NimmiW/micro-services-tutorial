package com.nimmiw.employee_service.repository;

import com.nimmiw.employee_service.EmployeeServiceApplication;
import com.nimmiw.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployee(Long id) {
        return employees.stream()
                .filter(a->a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream()
                .filter(a->a.departmentId().equals(departmentId))
                .toList();
    }

}
