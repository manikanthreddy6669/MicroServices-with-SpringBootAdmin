package com.example.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.DaoInterface;
import com.example.entity.Employee;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoInterface dao;
// Deleting Employee
public String deleteemp(Employee edata) 
{
	return dao.deleteemp(edata);
}
}