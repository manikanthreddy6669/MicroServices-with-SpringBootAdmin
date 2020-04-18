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
	public String UpdateEmployee(Employee emp,Employee edata) {
		// update operation

			edata.setName(emp.getName());
			edata.setSalary(emp.getSalary());
			edata.setPhonenumber(emp.getPhonenumber());
			edata.setCompany(emp.getCompany());
			em.merge(edata);
			return "Updated successfully";
	}
}
