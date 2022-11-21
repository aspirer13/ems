package com.rest.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rest.ems.dto.Department;

@Entity
@Table(name = "department", schema = "ems")
public class DepartmentEntity {

	@Id
	@Column(name="Name")
	private String name;

	@Column(name="EmployeeCount")
	private int employeeCount;

	@Column(name="Description")
	private String description;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Department")
	private List<EmployeeEntity> employeeList;

	public List<EmployeeEntity> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeEntity> employeeList) {
		this.employeeList = employeeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department transformEntityToDto() {
		Department de = new Department();
		de.setDescription(this.getDescription());
		de.setEmployeeCount(this.getEmployeeCount());
		de.setName(this.getName());
		return de;
	}

}
