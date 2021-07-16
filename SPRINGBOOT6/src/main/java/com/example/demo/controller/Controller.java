package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
public class Controller {
	
	@Autowired
	IEmployeeService ser;
	
	
	@GetMapping("/employees")
	public List<Employee>getAllEmployee()
	{
		return ser.getAllEmployee();
	}
	
	@GetMapping("/employees/name/{name}")
	public List<Employee>getEmployeeByName(@PathVariable String name)
	{
		return ser.getEmployeeByName(name);
	}
	
	@GetMapping("/employees/salary/{lower}/{higher}")
	public List<Employee>getEmployeeBySal(@PathVariable float lower,@PathVariable float higher)
	{
		return ser.getEmployeeBySal(lower, higher);
	}
	
	@GetMapping("/employee/{empID}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Employee getEmployee(@PathVariable int empID)
	{
		return ser.getEmployee(empID);
	}
	
	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	{
		return new  ResponseEntity<Employee>(ser.addEmployee(emp),HttpStatus.CREATED);
	}
	
	@PutMapping("/employee/{empID}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empID,@RequestBody Employee emp)
	{
		ser.updateEmployee(empID, emp);
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
		}
	
	@DeleteMapping("/employee/{empID}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable int empID)
	{
		
		ser.deleteEmployee(empID);
	}

}
