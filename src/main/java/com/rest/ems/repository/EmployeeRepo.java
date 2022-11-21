package com.rest.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.ems.entity.EmployeeEntity;

@Service
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

	@Modifying
	@Transactional
	@Query(value = "Delete from ems.employee e where e.NAME=?1", nativeQuery = true)
	public int deleteEmployee(String employeeName);

	@Modifying
	@Transactional
	@Query(value = "Update ems.employee e SET e.DESIGNATION=?1 where e.NAME=?2", nativeQuery = true)
	public int updateEmployee(String designation, String name);

	@Query(value = "Select * from Employee e where e.Name=?1", nativeQuery = true)
	public Optional<EmployeeEntity> findByName(String name);

}
