package com.rest.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.ems.constants.EmsStatusConstants;
import com.rest.ems.dto.Department;
import com.rest.ems.dto.Response;
import com.rest.ems.entity.DepartmentEntity;
import com.rest.ems.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;

	@Override
	public Response addDepartment(Department department) {

		try {
			DepartmentEntity de = department.transformDtoToEntity();
			DepartmentEntity result = departmentRepo.save(de);
			if (result != null) {
				return new Response(EmsStatusConstants.INSERTION_SUCCESS, EmsStatusConstants.INSERTION_SUCCESS_CODE);
			}
		} catch (Exception e) {
			return new Response(EmsStatusConstants.INSERTION_FAILED, EmsStatusConstants.INSERTION_FAILED_CODE);
		}
		return new Response(EmsStatusConstants.INSERTION_FAILED, EmsStatusConstants.INSERTION_FAILED_CODE);
	}

	@Override
	public Response deleteDepartment(String departmentName) {

		Optional<DepartmentEntity> entity = departmentRepo.findById(departmentName);
		if (!entity.isEmpty()) {
			int result = departmentRepo.deleteDepartment(departmentName);
			if (result == 1) {
				return new Response(EmsStatusConstants.DELETION_SUCCESS, EmsStatusConstants.DELETION_SUCCESS_CODE);
			}
			return new Response(EmsStatusConstants.DELETION_FAILED, EmsStatusConstants.DELETION_FAILED_CODE);
		} else {
			return new Response(EmsStatusConstants.NO_DEPARTMENT_FOUND, EmsStatusConstants.NO_DEPARTMENT_FOUND_CODE);
		}
	}

	@Override
	public Response updateDepartment(Department department, String departmentName) {

		Optional<DepartmentEntity> entity = departmentRepo.findById(departmentName);
		if (!entity.isEmpty()) {
			int result = departmentRepo.updateDepartment(department.getDescription(), departmentName);
			if (result == 1) {
				return new Response(EmsStatusConstants.UPDATION_SUCCESS, EmsStatusConstants.UPDATION_SUCCESS_CODE);
			}
			return new Response(EmsStatusConstants.UPDATION_FAILED, EmsStatusConstants.UPDATION_FAILED_CODE);
		} else {
			return new Response(EmsStatusConstants.NO_DEPARTMENT_FOUND, EmsStatusConstants.NO_DEPARTMENT_FOUND_CODE);
		}

	}

	@Override
	public Response addDepartmentAndEmployee(Department department) {
		DepartmentEntity de = new DepartmentEntity();
		de = department.transformDtoToEntity();

		DepartmentEntity result = departmentRepo.save(de);
		if (result != null) {
			return new Response(EmsStatusConstants.INSERTION_SUCCESS, EmsStatusConstants.INSERTION_SUCCESS_CODE);
		}
		return new Response(EmsStatusConstants.INSERTION_FAILED, EmsStatusConstants.INSERTION_FAILED_CODE);
	}

	@Override
	public List<Department> getDepartmentList() {
		List<DepartmentEntity> departmentEntityList = departmentRepo.findAll();
		List<Department> departmentList = new ArrayList<>();
//		TODO: employ lambda functions
		for (DepartmentEntity de : departmentEntityList) {
			departmentList.add(de.transformEntityToDto());
		}
		return departmentList;
	}

}
