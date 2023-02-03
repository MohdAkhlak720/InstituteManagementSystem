package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.StudentModel;
import com.example.demo.response.Response;
import com.example.demo.service.IStudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private IStudentService service;

	@ApiOperation(value = "new student addmission", response = StudentModel.class)
	@PostMapping()
	public ResponseEntity<StudentModel> addNewStudent(@RequestBody StudentModel model) {
		return new ResponseEntity<StudentModel>(service.create(model), HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a student by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) throws DataNotFoundException {
		StudentModel model = service.getById(id);
		Response response = new Response(new Date(), null, model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "get all student of given age and address", response = Response.class)
	@GetMapping("/")
	public ResponseEntity<Response> getByFields(@RequestParam Integer age, @RequestParam String address) {
		List<StudentModel> gatewayModels = service.getByAgeAndAddress(age, address);
		Response response = new Response(new Date(), null, gatewayModels);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "get all student", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAllStudent() {
		List<StudentModel> studentModels = service.getAllStudent();
		Response response = new Response(new Date(), null, studentModels);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Update an existing student", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateByID(@PathVariable Long id, @RequestBody StudentModel model)
			throws DataNotFoundException {
		StudentModel studentModel = service.updateById(id, model);
		Response response = new Response(new Date(), null, studentModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete an existing student by id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteByID(@PathVariable Long id) throws DataNotFoundException {
		StudentModel studentModel = service.deleteById(id);
		Response response = new Response(new Date(), null, studentModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
