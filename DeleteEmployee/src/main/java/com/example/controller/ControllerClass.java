package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.entity.Employee;
import com.example.service.ServiceClass;

@RestController
@RequestMapping("/Delete")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;
	@Autowired
	RestTemplate rest;

	// Deleting Employee
	@DeleteMapping("/DeleteEmployee/{id}")
	public ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		Employee edata = rest.getForObject("http://localhost:6669/Fetch/GetEmployee/"+id, Employee.class);
		if (edata != null) {
			String s = serviceobj.deleteemp(edata);
			return new ResponseEntity<String>(s, new HttpHeaders(), HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<String>("Delete Operation unsuccessful,Provided Id does not exist", new HttpHeaders(), HttpStatus.OK);
		}
	}

}
