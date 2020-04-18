package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Employee;
import com.example.dao.DaoInterface;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoInterface dao;

// Create Employee
public String EmployeeCreation(Employee emp) {
	return dao.EmployeeCreation(emp);
}

}