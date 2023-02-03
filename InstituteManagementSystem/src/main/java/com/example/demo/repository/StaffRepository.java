package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.StaffEntity;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
	List<StaffEntity> findByAgeAndAddressIgnoreCase(Integer age, String address);
}