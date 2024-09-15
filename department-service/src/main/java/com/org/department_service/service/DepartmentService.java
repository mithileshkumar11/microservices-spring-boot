package com.org.department_service.service;

import com.org.department_service.dto.DepartmentWithEmployeesDto;
import com.org.department_service.model.Department;
import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    void deleteDepartment(Long id);
    DepartmentWithEmployeesDto getWithEmployees(Long departmentId);
 
}
