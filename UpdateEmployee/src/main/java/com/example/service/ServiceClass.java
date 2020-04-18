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

// Updating Employee data
public String UpdateEmployee(Employee emp,Employee edata) {
	return dao.UpdateEmployee(emp,edata);	
}

}