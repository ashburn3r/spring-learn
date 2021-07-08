package com.cognizant.springlearn.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Exception.EmployeeNotFoundException;
import com.cognizant.springlearn.Model.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException{
		return employeeDao.updateEmployee(employee);
	}
	
	public Employee deleteEmployee(Employee employee)throws EmployeeNotFoundException{
		return employeeDao.deleteEmployee(employee);
	}
}
