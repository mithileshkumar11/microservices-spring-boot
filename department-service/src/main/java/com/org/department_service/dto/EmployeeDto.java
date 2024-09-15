package com.org.department_service.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
    private Long id;
    private String name;
    private String position;
    private Long departmentId;

}
