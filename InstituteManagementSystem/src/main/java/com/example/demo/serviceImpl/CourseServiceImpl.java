package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.CourseEntity;
import com.example.demo.entities.StudentEntity;
import com.example.demo.model.AssignCourseModel;
import com.example.demo.model.CourseModel;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public CourseModel addCourse(CourseModel model) {
		CourseEntity entity = modelToEntity(model);
		courseRepository.save(entity);
		model.setId(entity.getId());
		return model;
	}

	@Override
	public CourseModel getById(Long id) {
		Optional<CourseEntity> optional = courseRepository.findById(id);
		CourseModel model = null;
		if (optional.isPresent()) {
			CourseEntity entity = optional.get();
			model = entityToModel(entity);
			return model;
		}
		return null;
	}

	@Override
	public List<CourseModel> getAll() {
		List<CourseEntity> courseEntities = courseRepository.findAll();
		List<CourseModel> courseModels = new ArrayList<>();
		for (CourseEntity course : courseEntities) {
			courseModels.add(entityToModel(course));
		}
		return courseModels;
	}

	@Override
	public CourseModel updateById(Long id, CourseModel model) {
		Optional<CourseEntity> optional = courseRepository.findById(id);
		if (optional.isPresent()) {
			CourseEntity entity = optional.get();
			entity.setCourseName(model.getCourseName());
			entity.setCoursePrice(model.getCoursePrice());
			entity.setDate(model.getDate());
			entity.setDuration(model.getDuration());
			courseRepository.save(entity);
			model.setId(entity.getId());
			return model;
		}
		return null;
	}

	@Override
	public void assignCourse(AssignCourseModel model) {
		Optional<CourseEntity> courseOptional = courseRepository.findById(model.getCourseId());
		Optional<StudentEntity> studentOptional = studentRepository.findById(model.getStudentId());
		StudentEntity student = studentOptional.get();
		CourseEntity course = courseOptional.get();
		if (courseOptional.isPresent() && studentOptional.isPresent()) {
			if (student.getCourseSet() == null) {
				Set<CourseEntity> courseList = new HashSet<>();
				student.setCourseSet(courseList);
			}
			student.getCourseSet().add(course);
			studentRepository.save(student);
		}
	}

//	public void name(AssignCourseModel model) {
//		Optional<CourseEntity> courseOptional = courseRepository.findById(model.getCourseId());
//		Optional<StudentEntity> studentOptional = studentRepository.findById(model.getStudentId());
//		Enrollment enrollment = new Enrollment();
//		StudentEntity studentEntity = studentOptional.get();
//		CourseEntity courseEntity = courseOptional.get();
//		enrollment.setCourse(courseEntity);
//		enrollment.setStudent(studentEntity);
//		studentRepository.save(studentEntity);
//		enrollmentRepository.save(enrollment);
////		System.out.println(courseOptional.get());
//		System.out.println(studentOptional.get());
//	}

	private CourseEntity modelToEntity(CourseModel model) {
		CourseEntity entity = new CourseEntity();
		entity.setCourseName(model.getCourseName());
		entity.setCoursePrice(model.getCoursePrice());
		entity.setDate(model.getDate());
		entity.setDuration(model.getDuration());
		courseRepository.save(entity);
		model.setId(entity.getId());
		return entity;
	}

	private CourseModel entityToModel(CourseEntity entity) {
		CourseModel model = new CourseModel();
		model.setId(entity.getId());
		model.setCourseName(entity.getCourseName());
		model.setCoursePrice(entity.getCoursePrice());
		model.setDate(entity.getDate());
		model.setDuration(entity.getDuration());
		return model;

	}

}

//show columns from COURSE_REGISTER;
//select * from COURSE_REGISTER 