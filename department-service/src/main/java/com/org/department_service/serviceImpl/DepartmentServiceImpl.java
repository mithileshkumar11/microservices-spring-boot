package com.org.department_service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.department_service.client.EmployeeClient;
import com.org.department_service.dto.DepartmentWithEmployeesDto;
import com.org.department_service.dto.EmployeeDto;
import com.org.department_service.model.Department;
import com.org.department_service.repository.DepartmentRepository;
import com.org.department_service.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private EmployeeClient employeeClient;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

	@Override
	public DepartmentWithEmployeesDto getWithEmployees(Long departmentId) {
		List<EmployeeDto> employees=employeeClient.departmentId(departmentId);
		
		Department department=departmentRepository.findById(departmentId).orElse(null);
		DepartmentWithEmployeesDto deptWithEmp=new DepartmentWithEmployeesDto();
		deptWithEmp.setId(department.getId());
		deptWithEmp.setName(department.getName());
		deptWithEmp.setEmployees(employees);
		return deptWithEmp;
	}
}
