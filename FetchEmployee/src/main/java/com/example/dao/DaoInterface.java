package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface DaoInterface {

	Employee getEmployeeById(int id);

	List<Employee> getAllEmployee();
}
