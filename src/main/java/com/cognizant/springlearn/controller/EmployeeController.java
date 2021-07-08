package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Exception.EmployeeNotFoundException;
import com.cognizant.springlearn.Model.Employee;
import com.cognizant.springlearn.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(path = "/employee")
	public ResponseEntity<Employee> getEmployee() {
		Employee employee = context.getBean("employee1", Employee.class);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@GetMapping(path = "/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/updateEmployee")
	public void updateEmployee( @Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		log.info("start update");
		employeeService.updateEmployee(employee);
		log.debug("Employee = {}",employee);
		log.info("End Update");
	}
	
	@DeleteMapping("/deleteEmployee")
	public void deleteEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		log.info("Start Delete");
		employeeService.deleteEmployee(employee);
		log.debug("Employee ={}",employee);
		log.info("End delete");
	}

}
