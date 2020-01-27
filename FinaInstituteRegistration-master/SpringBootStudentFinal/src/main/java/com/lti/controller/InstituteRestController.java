package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Institute;
import com.lti.model.Response;
import com.lti.service.InstituteService;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class InstituteRestController {
	@Autowired
	private InstituteService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response<String> addInstitute(@RequestBody Institute institute) {
		//ResponseEntity<String> response;
		boolean result=service.addInstitute(institute);
		Response<String> response = new Response<String>();
		if (result) {
			response.setResponseCode(200);
			response.setResponseMessage("Success");
			response.setResponseObject("Student Registered");

		} else {
			response.setResponseCode(400);
			response.setResponseMessage("Failed");
			response.setResponseObject("Registration Failed");
//			response=new ResponseEntity<String>("User Not Added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(path="{instituteCode}/{setPassword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<String> LoginInstitute(@PathVariable("instituteCode") int instituteCode,@PathVariable("setPassword") String setPassword) {
		//ResponseEntity<String> response;
		
		boolean result =  service.loginInstitute(instituteCode, setPassword);
		System.out.println("Result " + result);
		Response<String> response = new Response<String>();
		if (result) {
			response.setResponseCode(200);
			response.setResponseMessage("Success");
			response.setResponseObject("Login Successful");

		} else {
			response.setResponseCode(400);
			response.setResponseMessage("Failed");
			response.setResponseObject("Student does not exist");

		}
		return response;
}
