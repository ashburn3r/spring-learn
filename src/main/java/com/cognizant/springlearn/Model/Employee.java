package com.cognizant.springlearn.Model;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	@NotNull
	@Min(value=0)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 1,max = 30)
	private String name;
	@NotNull
	@Min(value=0)
	private double salary;
	private Department department;
	private List<Skill> skills;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", skills=" + skills + "]";
	}

	public Employee(int id, String name, double salary, Department department, List<Skill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.skills = skills;
	}

	public Employee() {
		super();
	}

}
