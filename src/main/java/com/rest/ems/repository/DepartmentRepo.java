package com.rest.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.ems.entity.DepartmentEntity;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, String> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM EMS.DEPARTMENT WHERE NAME=?1", nativeQuery = true)
	public int deleteDepartment(String departmentName);

	@Modifying
	@Transactional
	@Query(value = "UPDATE ems.department d SET d.Description=?1 WHERE d.Name=?2",nativeQuery=true)
	public int updateDepartment(String departmentDescription, String departmentName);

}
