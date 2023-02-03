package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AssignCourseModel;
import com.example.demo.model.CourseModel;

public interface ICourseService {
	public CourseModel addCourse(CourseModel model);

	public CourseModel getById(Long id);

	public List<CourseModel> getAll();

	public CourseModel updateById(Long id, CourseModel model);

	public void assignCourse(AssignCourseModel model);
}
