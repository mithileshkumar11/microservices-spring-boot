package com.org.department_service.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.department_service.dto.DepartmentWithEmployeesDto;
import com.org.department_service.model.Department;
import com.org.department_service.service.DepartmentService;
import com.org.department_service.serviceImpl.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	private static final Logger logger = LogManager.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
    	logger.info("Save Department Data: {}",department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
    	logger.info("Get Department Data: ALL");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
    	logger.info("Get Department Data: Id:{}",id);
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
    	logger.info("Delete Department Data:id {}",id);
        departmentService.deleteDepartment(id);
    }
    
    @GetMapping("/withEmployees/{departmentId}")
    public DepartmentWithEmployeesDto findByDepartmentId(@PathVariable Long departmentId) {
    	logger.info("Find By DepartmentId: {}",departmentId);
        return departmentService.getWithEmployees(departmentId);
    }
    
}
