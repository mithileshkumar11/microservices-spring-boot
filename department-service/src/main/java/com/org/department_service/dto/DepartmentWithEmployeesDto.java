package com.org.department_service.dto;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentWithEmployeesDto {
	private Long id;
	private String name;
	private List<EmployeeDto> employees;
}
