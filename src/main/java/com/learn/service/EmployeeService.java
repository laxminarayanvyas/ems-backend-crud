package com.learn.service;

import java.util.List;

import com.learn.entity.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee emp);
	
	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployee();
	
	Employee updateEmployee(Long id, Employee emp);
	
	void deleteEmployee(Long id);

}
