package com.rest.ems.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.rest.ems.entity.DepartmentEntity;
import com.rest.ems.entity.EmployeeEntity;

public class Department {

	private String name;

	private int employeeCount;

	private String description;

	private List<Employee> employeeList;

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@JsonSetter("employees")
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public String getName() {
		return name;
	}

	@JsonSetter("name")
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

	@JsonSetter("desc")
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", employeeCount=" + employeeCount + ", description=" + description
				+ ", employeeList=" + employeeList + "]";
	}

	public DepartmentEntity transformDtoToEntity() {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setDescription(this.getDescription());
		entity.setEmployeeCount(this.getEmployeeCount());
		entity.setName(this.getName());
		List<EmployeeEntity> employeeEntityList = new ArrayList<>();
		for (Employee employee : this.getEmployeeList()) {
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity = employee.transformDtoToEntity();
			employeeEntityList.add(employeeEntity);
		}
		entity.setEmployeeList(employeeEntityList);
		return entity;
	}

}
