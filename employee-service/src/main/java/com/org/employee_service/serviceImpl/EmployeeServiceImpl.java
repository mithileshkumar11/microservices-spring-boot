package com.org.employee_service.serviceImpl;


import com.org.employee_service.model.Employee;
import com.org.employee_service.repository.EmployeeRepository;
import com.org.employee_service.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

	@Override
	public List<Employee> getDepartmentById(Long departementId) {
		return employeeRepository.findByDepartmentId(departementId);
	}
}

