package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;
import com.example.service.ServiceClass;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Add")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;
	@Autowired
	RestTemplate rest;

	// Create Employee
	@PostMapping("/EmployeeCreation")
	public ResponseEntity<String> EmployeeCreation(@RequestBody Employee emp) {
		Employee get = rest.getForObject("http://localhost:6669/Fetch/GetEmployee/" + emp.getId(), Employee.class);
		if (get == null) {
			String s = serviceobj.EmployeeCreation(emp);
			return new ResponseEntity<String>(s, new HttpHeaders(), HttpStatus.OK);
		} else
			return new ResponseEntity<String>("Id Already exists", new HttpHeaders(), HttpStatus.OK);

	}

}
