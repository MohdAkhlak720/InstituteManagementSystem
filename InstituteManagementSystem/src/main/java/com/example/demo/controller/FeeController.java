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

import com.example.demo.model.FeeModel;
import com.example.demo.response.Response;
import com.example.demo.service.IStudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/fee")
public class FeeController {

	@Autowired
	private IStudentService service;

	@ApiOperation(value = "Deposit fee", response = Response.class)
	@PostMapping()
	public ResponseEntity<FeeModel> deposit(@RequestBody FeeModel feeModel) {
		return new ResponseEntity<>(service.depositFee(feeModel), HttpStatus.CREATED);
	}

	@ApiOperation(value = "get a fee by given id", response = Response.class)
	@GetMapping("/{studentId}")
	public ResponseEntity<Response> getById(@PathVariable("studentId") Long studentId) {
		List<FeeModel> model = service.getFeeById(studentId);
		Response response = new Response(new Date(), null, model);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
