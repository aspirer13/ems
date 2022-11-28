package com.rest.ems.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.rest.ems.entity.EmployeeEntity;

public class Employee {

	private int id;

	private String name;

	private String department;

	private String designation;

	private LocalDate joiningDate;

	private String employeeType;

	public String getEmployeeType() {
		return employeeType;
	}

	@JsonSetter("type")
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	@JsonSetter("jDate")
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public EmployeeEntity transformDtoToEntity() {
		EmployeeEntity ee = new EmployeeEntity();
		ee.setDepartment(this.getDepartment());
		ee.setDesignation(this.getDesignation());
		ee.setId(this.getId());
		ee.setJoiningDate(this.getJoiningDate());
		ee.setName(this.getName());
		ee.setEmployeeType(this.getEmployeeType());
		return ee;
	}

}
