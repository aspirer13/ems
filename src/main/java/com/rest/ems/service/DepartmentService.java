package com.rest.ems.service;

import java.util.List;

import com.rest.ems.dto.Department;
import com.rest.ems.dto.Response;

public interface DepartmentService {

	public Response addDepartment(Department department);

	public Response deleteDepartment(String departmentName);

	public Response updateDepartment(Department department, String departmentDescription);

	public Response addDepartmentAndEmployee(Department department);

	public List<Department> getDepartmentList();

}
