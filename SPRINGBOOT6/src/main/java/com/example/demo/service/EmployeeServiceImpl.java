package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	@Override
	public List<Employee> getAllEmployee()
	{
		return dao.findAll();
	}
	@Override
	public List<Employee> getEmployeeByName(String name)
	{
		
		return dao.getUsingEmpName(name);
		
	}
	
	
	@Override
	public List<Employee> getEmployeeBySal(float lower,float higher)
	{
		
		return dao.getEmployeeBySal(lower, higher);
		
	}
	
	@Override
	public Employee getEmployee(int empID)
	{
		
		return dao.getById(empID);
		
	}
	
	@Override
	public Employee addEmployee(Employee emp)
	{
		return dao.save(emp);
	}
	
	@Override
	public Employee updateEmployee(int empID,Employee emp)
	{
		return dao.save(emp);
	}
	
	@Override
	public void deleteEmployee(int empID)
	{
		dao.deleteById(empID);
	}
	
	

}
