package com.rest.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rest.ems.dto.Employee;

@Entity
@Table(name = "employee", schema = "ems")
public class EmployeeEntity {

	@Id
	@Column(name = "Id")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Department")
	private String department;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Joining_Date")
	private LocalDate joiningDate;

	@Column(name = "Status")
	private String employeeType;

	public String getEmployeeType() {
		return employeeType;
	}

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

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Employee transformEntityToDto() {
		Employee ee = new Employee();
		ee.setDepartment(this.getDepartment());
		ee.setDesignation(this.designation);
		ee.setId(this.id);
		ee.setJoiningDate(this.getJoiningDate());
		ee.setName(this.name);
		ee.setEmployeeType(this.getEmployeeType());
		return ee;
	}
}
