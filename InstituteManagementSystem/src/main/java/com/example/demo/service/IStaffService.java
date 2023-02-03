package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.SalaryModel;
import com.example.demo.model.StaffModel;

public interface IStaffService {
	public StaffModel create(StaffModel model);

	public StaffModel get(Long id) throws DataNotFoundException;

	public List<StaffModel> get(Integer age, String address);

	public List<StaffModel> getAll();

	public StaffModel update(Long id, StaffModel model) throws DataNotFoundException;

	public StaffModel delete(Long id) throws DataNotFoundException;

	public SalaryModel giveSalary(SalaryModel salaryModel) throws DataNotFoundException;

	List<SalaryModel> getSalaryById(Long staffId);
}
