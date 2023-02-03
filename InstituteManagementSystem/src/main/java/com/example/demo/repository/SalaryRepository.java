package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.SalaryEntity;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {

	@Query(value = "select * from salary s where s.STAFF_ID =?1", nativeQuery = true)
	List<SalaryEntity> findByStaffEntity(Long staffId);

}
