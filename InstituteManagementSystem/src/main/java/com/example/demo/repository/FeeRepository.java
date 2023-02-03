package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.FeeEntity;

@Repository
public interface FeeRepository extends JpaRepository<FeeEntity, Long> {

	@Query(value = "select * from fee f where f.STUDENT_ID =?1", nativeQuery = true)
	List<FeeEntity> findByStudentEntity(Long studentId);
}
