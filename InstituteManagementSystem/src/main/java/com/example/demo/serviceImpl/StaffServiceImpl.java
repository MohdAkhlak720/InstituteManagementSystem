package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.SalaryEntity;
import com.example.demo.entities.StaffEntity;
import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.SalaryModel;
import com.example.demo.model.StaffModel;
import com.example.demo.repository.SalaryRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.IStaffService;

@Service
public class StaffServiceImpl implements IStaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public StaffModel create(StaffModel model) {
		StaffEntity entity = modelToEntity(model);
		staffRepository.save(entity);
		model.setId(entity.getId());
		return model;
	}

	@Override
	public StaffModel get(Long id) throws DataNotFoundException {
		Optional<StaffEntity> optional = staffRepository.findById(id);
		StaffModel model = null;
		if (optional.isPresent()) {
			StaffEntity entity = optional.get();
			model = entityToModel(entity);
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
		return model;
	}

	@Override
	public List<StaffModel> get(Integer age, String address) {
		List<StaffEntity> staffEntities = staffRepository.findByAgeAndAddressIgnoreCase(age, address);
		List<StaffModel> staffModels = new ArrayList<>();
		for (StaffEntity object : staffEntities) {
			staffModels.add(entityToModel(object));
		}
		return staffModels;
	}

	@Override
	public List<StaffModel> getAll() {
		List<StaffEntity> staffEntities = staffRepository.findAll();
		List<StaffModel> staffModels = new ArrayList<>();
		for (StaffEntity object : staffEntities) {
			staffModels.add(entityToModel(object));
		}
		return staffModels;
	}

	@Override
	public StaffModel update(Long id, StaffModel model) throws DataNotFoundException {
		Optional<StaffEntity> optional = staffRepository.findById(id);
		if (optional.isPresent()) {
			StaffEntity entity = optional.get();
			entity.setName(model.getName());
			entity.setAge(model.getAge());
			entity.setPhone(model.getPhone());
			entity.setPincode(model.getPincode());
			entity.setAddress(model.getAddress());
			staffRepository.save(entity);
			model.setId(entity.getId());
			return model;
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
	}

	@Override
	public StaffModel delete(Long id) throws DataNotFoundException {
		Optional<StaffEntity> optional = staffRepository.findById(id);
		StaffModel model = null;
		if (optional.isPresent()) {
			StaffEntity entity = optional.get();
			model = entityToModel(entity);
			staffRepository.deleteById(id);
			return model;
		} else {
			throw new DataNotFoundException("Data not found for the given id.");
		}
	}

	@Override
	public SalaryModel giveSalary(SalaryModel salaryModel) throws DataNotFoundException {
		Optional<StaffEntity> optional = staffRepository.findById(salaryModel.getStaffId());
		SalaryEntity salaryEntity = null;
		if (optional.isPresent()) {
			StaffEntity staffEntity = optional.get();
			salaryEntity = new SalaryEntity();
			salaryEntity.setDate(salaryModel.getDate());
			salaryEntity.setSalary(salaryModel.getSalary());
//			salaryEntity.setStaff (staffEntity);
			salaryEntity.setStaffEntity(staffEntity);
			salaryRepository.save(salaryEntity);
			salaryModel.setId(salaryEntity.getId());
			if (staffEntity.getEntities() == null) {
				staffEntity.setEntities(new ArrayList<>());
			}
			staffEntity.getEntities().add(salaryEntity);
			staffRepository.save(staffEntity);
			return salaryModel;
		} else {
			throw new DataNotFoundException("Data not found");
		}
	}

	@Override
	public List<SalaryModel> getSalaryById(Long staffId) {
		List<SalaryEntity> salaries = salaryRepository.findByStaffEntity(staffId);
		List<SalaryModel> salaryList = new ArrayList<>();
		SalaryModel model = null;
		for (SalaryEntity salary : salaries) {
			model = new SalaryModel();
			model.setId(salary.getId());
			model.setSalary(salary.getSalary());
			model.setDate(salary.getDate());
			model.setStaffId(salary.getStaffEntity().getId());
			salaryList.add(model);
		}
		return salaryList;
	}

	private StaffEntity modelToEntity(StaffModel model) {
		StaffEntity entity = new StaffEntity();
		entity.setName(model.getName());
		entity.setPhone(model.getPhone());
		entity.setAge(model.getAge());
		entity.setAddress(model.getAddress());
		entity.setStaff(model.getStaff());
		entity.setPhone(model.getPhone());
		entity.setPincode(model.getPincode());
		staffRepository.save(entity);
		model.setId(entity.getId());
		return entity;
	}

	private StaffModel entityToModel(StaffEntity entity) {
		StaffModel model = new StaffModel();
		model.setId(entity.getId());
		model.setAge(entity.getAge());
		model.setAddress(entity.getAddress());
		model.setName(entity.getName());
		model.setPhone(entity.getPhone());
		model.setPincode(entity.getPincode());
		model.setPhone(entity.getPhone());
		model.setStaff(entity.getStaff());
		return model;
	}

}
