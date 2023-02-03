package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.FeeEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.CourseModel;
import com.example.demo.model.FeeModel;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.FeeRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private FeeRepository feeRepository;

	@Override
	public StudentModel create(StudentModel model) {
		StudentEntity entity = modelToEntity(model);
		studentRepository.save(entity);
		model.setId(entity.getId());
		return model;
	}

	@Override
	public StudentModel getById(Long id) throws DataNotFoundException {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		StudentModel model = null;
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			model = entityToModel(entity);
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
		return model;
	}

	@Override
	public List<StudentModel> getByAgeAndAddress(Integer age, String address) {
		List<StudentEntity> studentEntities = studentRepository.findByAgeAndAddressIgnoreCase(age, address);
		List<StudentModel> studentModels = new ArrayList<>();
		for (StudentEntity object : studentEntities) {
			studentModels.add(entityToModel(object));
		}
		return studentModels;
	}

	@Override
	public List<StudentModel> getAllStudent() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		List<StudentModel> studentModels = new ArrayList<>();
		for (StudentEntity object : studentEntities) {
			studentModels.add(entityToModel(object));
		}
		return studentModels;
	}

	@Override
	public StudentModel updateById(Long id, StudentModel model) throws DataNotFoundException {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			entity.setName(model.getName());
			entity.setFatherName(model.getFatherName());
			entity.setAge(model.getAge());
			entity.setPhone(model.getPhone());
			entity.setClassName(model.getClassName());
			entity.setPincode(model.getPincode());
			entity.setAddress(model.getAddress());
			studentRepository.save(entity);
			model.setId(entity.getId());
			return model;
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
	}

	@Override
	public StudentModel deleteById(Long id) throws DataNotFoundException {
		Optional<StudentEntity> optional = studentRepository.findById(id);
		StudentModel model = null;
		if (optional.isPresent()) {
			StudentEntity entity = optional.get();
			model = entityToModel(entity);
			studentRepository.deleteById(id);
			return model;
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
	}

	@Override
	public FeeModel depositFee(FeeModel feeModel) {
		Optional<StudentEntity> optional = studentRepository.findById(feeModel.getStudentId());
		FeeEntity feeEntity = null;
		if (optional.isPresent()) {
			StudentEntity studentEntity = optional.get();
			feeEntity = new FeeEntity();
			feeEntity.setDate(feeModel.getDate());
			feeEntity.setFee(feeModel.getFee());
			feeEntity.setStudentEntity(studentEntity);
			feeModel.setId(studentEntity.getId());
			feeRepository.save(feeEntity);
			feeModel.setId(feeEntity.getId());
			if (studentEntity.getFeeEntities() == null) {
				studentEntity.setFeeEntities(new ArrayList<>());
			}
			studentEntity.getFeeEntities().add(feeEntity);
			studentRepository.save(studentEntity);
		}
		return feeModel;
	}

	@Override
	public List<FeeModel> getFeeById(Long studentId) {
		List<FeeEntity> optional = feeRepository.findByStudentEntity(studentId);
		List<FeeModel> feeList = new ArrayList<>();
		FeeModel model = null;
		for (FeeEntity fee : optional) {
			model = new FeeModel();
			model.setId(fee.getId());
			model.setFee(fee.getFee());
			model.setDate(fee.getDate());
			model.setStudentId(fee.getStudentEntity().getId());
			feeList.add(model);
		}
		return feeList;
	}

	private StudentEntity modelToEntity(StudentModel model) {
		StudentEntity entity = new StudentEntity();
		entity.setName(model.getName());
		entity.setAddress(model.getAddress());
		entity.setPincode(model.getPincode());
		entity.setAge(model.getAge());
		entity.setFatherName(model.getFatherName());
		entity.setPhone(model.getPhone());
		entity.setClassName(model.getClassName());
		return entity;
	}

	private StudentModel entityToModel(StudentEntity entity) {
		StudentModel model = new StudentModel();
		model.setAddress(entity.getAddress());
		model.setAge(entity.getAge());
		model.setClassName(entity.getClassName());
		model.setFatherName(entity.getFatherName());
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setPhone(entity.getPhone());
		model.setPincode(entity.getPincode());
		model.setCourseModel(new HashSet<>());
		for (CourseEntity courseEntity : entity.getCourseSet()) {
			CourseModel courseModel = new CourseModel();
			courseModel.setId(courseEntity.getId());
			courseModel.setCourseName(courseEntity.getCourseName());
			courseModel.setDate(courseEntity.getDate());
			courseModel.setCoursePrice(courseEntity.getCoursePrice());
			courseModel.setDuration(courseEntity.getDuration());
			model.getCourseModel().add(courseModel);
		}
		model.setFeeModel(new HashSet<>());
		for (FeeEntity feeEntity : entity.getFeeEntities()) {
			FeeModel feeModel = new FeeModel();
			feeModel.setId(feeEntity.getId());
			feeModel.setDate(feeEntity.getDate());
			feeModel.setFee(feeEntity.getFee());
			feeModel.setStudentId(feeEntity.getStudentEntity().getId());
			model.getFeeModel().add(feeModel);
		}
		return model;
	}

}