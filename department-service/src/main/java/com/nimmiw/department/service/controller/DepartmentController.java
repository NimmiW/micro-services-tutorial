package com.nimmiw.department.service.controller;

import com.nimmiw.department.service.client.EmployeeClient;
import com.nimmiw.department.service.model.Department;
import com.nimmiw.department.service.repository.DepartmentRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentRespository respository;
    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        return respository.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAll() {
        return respository.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return respository.getDepartment(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllWithEmployees() {
        List<Department> departments = respository.getAllDepartments();
        departments.forEach(department -> department.setEmployees(
                employeeClient.findEmployeeByDepartment(department.getId())
        ));
        return departments;
    }
}
