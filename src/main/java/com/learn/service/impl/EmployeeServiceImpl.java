package com.learn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Exception.ResourceNotFoundException;
import com.learn.entity.Employee;
import com.learn.repository.EmployeeRepo;
import com.learn.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Employee createEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
//		System.out.println("getemp");
		return empRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist"
				+ "with given id "+id));
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmp) {
		// TODO Auto-generated method stub
		Employee emp= empRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not "
				+ "exist with given id "+id));
		
		
		
		if(emp!=null) {
			updatedEmp.setId(emp.getId());  

		    // Save the updated employee
		    empRepo.save(updatedEmp);
		}
		return updatedEmp;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		
	}
	

}
