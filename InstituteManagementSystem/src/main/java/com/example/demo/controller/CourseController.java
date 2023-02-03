package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CourseModel;
import com.example.demo.response.Response;
import com.example.demo.service.ICourseService;
import com.example.demo.serviceImpl.CourseServiceImpl;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	private ICourseService service;

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@PostMapping()
	public ResponseEntity<CourseModel> addCourse(@RequestBody CourseModel model) {
		return new ResponseEntity<CourseModel>(service.addCourse(model), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> CourseGetById(@PathVariable Long id) {
		CourseModel model = service.getById(id);
		Response response = new Response(new Date(), null, model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Response> getAllCourses() {
		List<CourseModel> courseModel = service.getAll();
		Response response = new Response(new Date(), null, courseModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Response> updateCourse(@PathVariable Long id, @RequestBody CourseModel model) {
		CourseModel courseModel = service.updateById(id, model);
		Response response = new Response(new Date(), null, courseModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
//
//	@PostMapping("/")
//	private void name(@RequestBody AssignCourseModel model) {
//		impl.name(model);
//		impl.name(null);
//	}
}
