package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptionhandler.DataNotFoundException;
import com.example.demo.model.SalaryModel;
import com.example.demo.model.StudentModel;
import com.example.demo.response.Response;
import com.example.demo.service.IStaffService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/salary")
public class SalaryController {

	@Autowired
	private IStaffService service;

	@ApiOperation(value = "Give salary", response = StudentModel.class)
	@PostMapping()
	public ResponseEntity<SalaryModel> salary(@RequestBody SalaryModel model) throws DataNotFoundException {
		return new ResponseEntity<SalaryModel>(service.giveSalary(model), HttpStatus.CREATED);

	}

	@ApiOperation(value = "get a salary by given id", response = Response.class)
	@GetMapping("/{staffId}")
	public ResponseEntity<Response> getSalaryByStaffId(@PathVariable("staffId") Long staffId) {
		List<SalaryModel> model = service.getSalaryById(staffId);
		Response response = new Response(new Date(), null, model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
