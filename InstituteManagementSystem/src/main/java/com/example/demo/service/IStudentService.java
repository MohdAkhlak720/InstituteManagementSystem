package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.FeeModel;
import com.example.demo.model.StudentModel;

public interface IStudentService {

	public StudentModel create(StudentModel model);

	public StudentModel getById(Long id) throws DataNotFoundException;

	public List<StudentModel> getByAgeAndAddress(Integer age, String address);

	public List<StudentModel> getAllStudent();

	public StudentModel updateById(Long id, StudentModel model) throws DataNotFoundException;

	public StudentModel deleteById(Long id) throws DataNotFoundException;

	public FeeModel depositFee(FeeModel feeModel);

	public List<FeeModel> getFeeById(Long studentId);

}
