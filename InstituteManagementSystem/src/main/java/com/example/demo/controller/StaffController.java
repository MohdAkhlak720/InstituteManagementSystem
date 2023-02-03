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
import com.example.demo.model.StaffModel;
import com.example.demo.response.Response;
import com.example.demo.service.IStaffService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/staff")
public class StaffController {

	@Autowired
	private IStaffService service;

	@ApiOperation(value = "add new staff", response = StaffModel.class)
	@PostMapping()
	public ResponseEntity<StaffModel> newStaff(@RequestBody StaffModel model) {
		return new ResponseEntity<StaffModel>(service.create(model), HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a staff by given id", response = Response.class)
	@GetMapping("/{id}")
	public ResponseEntity<Response> getStaffByID(@PathVariable Long id) throws DataNotFoundException {
		StaffModel model = service.get(id);
		Response response = new Response(new Date(), null, model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "get all staff of a given age and address", response = Response.class)
	@GetMapping("/")
	public ResponseEntity<Response> getByAgeAndAddress(@RequestParam Integer age, @RequestParam String address) {
		List<StaffModel> staffModels = service.get(age, address);
		Response response = new Response(new Date(), null, staffModels);
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "get all staff", response = Response.class)
	@GetMapping()
	public ResponseEntity<Response> getAllStaff() {
		List<StaffModel> staffModels = service.getAll();
		Response response = new Response(new Date(), null, staffModels);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Update an existing staff", response = Response.class)
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateByID(@PathVariable Long id, @RequestBody StaffModel model)
			throws DataNotFoundException {
		StaffModel staffModel = service.update(id, model);
		Response response = new Response(new Date(), null, staffModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete an existing staff by id", response = Response.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteByID(@PathVariable Long id) throws DataNotFoundException {
		StaffModel staffModel = service.delete(id);
		Response response = new Response(new Date(), null, staffModel);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
