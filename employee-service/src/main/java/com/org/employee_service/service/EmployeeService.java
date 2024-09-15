package com.org.employee_service.service;

import java.util.List;

import com.org.employee_service.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    List<Employee> getDepartmentById(Long departementId);
}
