package com.example.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public class DaoClass implements DaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Employee getEmployeeById(int id) {
		return em.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		Query q = em.createQuery("select m from Employee m");
		List<Employee> emplist = q.getResultList();
		return emplist;
	}
}
