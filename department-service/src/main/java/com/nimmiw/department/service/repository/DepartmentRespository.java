package com.nimmiw.department.service.repository;

import com.nimmiw.department.service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRespository {
    private List<Department> departments = new ArrayList<>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department getDepartment(Long id) {
        return departments.stream().
                filter(department -> department.getId().equals(id))
                .findFirst().orElse(null);
    }

    public List<Department> getAllDepartments() {
        return departments;
    }
}
