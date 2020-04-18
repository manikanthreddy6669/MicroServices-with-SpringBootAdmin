package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class DaoClass implements DaoInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public String EmployeeCreation(Employee emp) {
		em.merge(emp);
		return "Employee created successfully";
	}

	
}
