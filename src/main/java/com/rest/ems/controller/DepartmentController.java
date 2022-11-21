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

import com.rest.ems.dto.Department;
import com.rest.ems.dto.Response;
import com.rest.ems.service.DepartmentServiceImpl;

@RestController
@RequestMapping(path = "/ems/department")
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl departmentServiceImpl;

	@PostMapping(value = "/addDepartment")
	public ResponseEntity<Response> createDepartment(@RequestBody Department department) {

		Response result = departmentServiceImpl.addDepartment(department);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteDepartment/{name}")
	public ResponseEntity<Response> deleteDepartment(@PathVariable(value = "name") String departmentName) {

		Response result = departmentServiceImpl.deleteDepartment(departmentName);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	@PutMapping(value = "/updateDepartment/{name}")
	public ResponseEntity<Response> updateDepartment(@PathVariable(value = "name") String departmentName,
			@RequestBody Department department) {
	
		Response result = departmentServiceImpl.updateDepartment(department, departmentName);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllDepartments")
	public ResponseEntity<List<Department>> getAllDepartments() {
		
		List<Department> departmentList = departmentServiceImpl.getDepartmentList();
		return new ResponseEntity<>(departmentList, HttpStatus.OK);
	}

	@PostMapping(value = "/addDepartmentAndEmployees")
	public ResponseEntity<Response> addDepartmentAndEmployees(@RequestBody Department department) {

		Response result = departmentServiceImpl.addDepartmentAndEmployee(department);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
