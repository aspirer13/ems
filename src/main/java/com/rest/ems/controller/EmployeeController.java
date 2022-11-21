package com.rest.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.ems.constants.EmsStatusConstants;
import com.rest.ems.dto.Employee;
import com.rest.ems.dto.Response;
import com.rest.ems.service.EmployeeServiceImpl;

@RestController
@RequestMapping(path = "/ems/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {

		Response result = employeeService.addEmployee(employee);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteEmployee/{name}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable(value = "name") String employeeName) {

		Response result = employeeService.deleteEmployee(employeeName);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PutMapping(value = "/updateEmployee/{name}")
	public ResponseEntity<Response> updateEmployee(@PathVariable(value = "name") String employeeName,
			@RequestBody Employee employee) {

		Response result = employeeService.updateEmployee(employee, employeeName);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> employeeList = employeeService.getEmployeeList();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping(value = "/getEmployeeByName/{name}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable(value = "name") String employeeName) {

		Employee employee = employeeService.getEmployeeByName(employeeName);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping(value = "/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeByName(@PathVariable(value = "id") int employeeId) {
		
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

}
