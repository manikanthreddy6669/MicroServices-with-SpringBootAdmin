package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;
import com.example.service.ServiceClass;
@RestController
@RequestMapping("/Fetch")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

	// Get Particular Employee Data
	@GetMapping("/GetEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		Employee e = serviceobj.getEmployeeById(id);
			return e;
	}

	// Get All Employees Data
	@GetMapping("/GetAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emplist = serviceobj.getAllEmployee();
		return new ResponseEntity<List<Employee>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}


}
