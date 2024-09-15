package com.org.department_service.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.org.department_service.dto.EmployeeDto;

@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/api/employee/department/{departmentId}")
    public List<EmployeeDto> departmentId(@PathVariable Long departmentId);

}
