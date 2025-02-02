package com.nimmiw.department.service.client;

import com.nimmiw.department.service.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("employee/department/{departmentId}")
    public List<Employee> findEmployeeByDepartment(@PathVariable Long departmentId);
}
