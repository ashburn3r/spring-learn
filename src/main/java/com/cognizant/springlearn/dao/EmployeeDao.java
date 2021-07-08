package com.cognizant.springlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.Exception.EmployeeNotFoundException;
import com.cognizant.springlearn.Model.Employee;

@Component
public class EmployeeDao {
	private static List<Employee> employeeList;
	
	public EmployeeDao() {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("emp.xml");
		employeeList= context.getBean("employeeList",List.class);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeList;
	}
	
	public Employee updateEmployee(Employee employee)  throws EmployeeNotFoundException{
		for(Employee e:employeeList) {
			if(e.getId()==employee.getId()){
				employeeList.remove(e);
				employeeList.add(employee);
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}
	
	public Employee deleteEmployee(Employee employee) throws EmployeeNotFoundException{
		for(Employee e:employeeList) {
			if(e.getId()==employee.getId()) {
				employeeList.remove(e);
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}
}
