package com.rest.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.ems.constants.EmsStatusConstants;
import com.rest.ems.dto.Employee;
import com.rest.ems.dto.Response;
import com.rest.ems.entity.EmployeeEntity;
import com.rest.ems.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Response addEmployee(Employee employee) {
		EmployeeEntity ee = employee.transformDtoToEntity();
		EmployeeEntity result = employeeRepo.save(ee);
		if (result != null) {
			return new Response(EmsStatusConstants.INSERTION_SUCCESS, EmsStatusConstants.INSERTION_SUCCESS_CODE);
		}
		return new Response(EmsStatusConstants.INSERTION_FAILED, EmsStatusConstants.INSERTION_FAILED_CODE);
	}

	@Override
	public Response deleteEmployee(String employeeName) {
		int result = employeeRepo.deleteEmployee(employeeName);
		if (result == 1) {
			return new Response(EmsStatusConstants.DELETION_SUCCESS, EmsStatusConstants.DELETION_SUCCESS_CODE);
		}
		return new Response(EmsStatusConstants.NO_EMPLOYEE_FOUND, EmsStatusConstants.NO_EMPLOYEE_FOUND_CODE);
	}

	@Override
	public Response updateEmployee(Employee employee, String name) {

		Optional<EmployeeEntity> ee = employeeRepo.findByName(name);
		if (!ee.isEmpty()) {
			int result = employeeRepo.updateEmployee(employee.getDesignation(), name);
			if (result == 1) {
				return new Response(EmsStatusConstants.UPDATION_SUCCESS, EmsStatusConstants.UPDATION_SUCCESS_CODE);
			}
			return new Response(EmsStatusConstants.UPDATION_FAILED, EmsStatusConstants.UPDATION_FAILED_CODE);
		}

		return new Response(EmsStatusConstants.NO_EMPLOYEE_FOUND, EmsStatusConstants.NO_EMPLOYEE_FOUND_CODE);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Optional<EmployeeEntity> ee = employeeRepo.findByName(name);
		if (ee.isPresent()) {
			Employee employee = ee.get().transformEntityToDto();
			return employee;
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<EmployeeEntity> ee = employeeRepo.findById(employeeId);
		if (ee.isPresent()) {
			Employee employee = ee.get().transformEntityToDto();
			return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
		List<Employee> employeeList = new ArrayList<>();
		for (EmployeeEntity ee : employeeEntityList) {
			Employee employee = ee.transformEntityToDto();
			employeeList.add(employee);
		}
		return employeeList;
	}

}
