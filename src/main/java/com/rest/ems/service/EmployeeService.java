package com.rest.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.ems.dto.Employee;
import com.rest.ems.dto.Response;

@Service
public interface EmployeeService {

	public Response addEmployee(Employee employee);

	public Response deleteEmployee(String employeeName);

	public Response updateEmployee(Employee employee, String designation);

	public Employee getEmployeeByName(String name);

	public Employee getEmployeeById(int employeeId);

	public List<Employee> getEmployeeList();

}
