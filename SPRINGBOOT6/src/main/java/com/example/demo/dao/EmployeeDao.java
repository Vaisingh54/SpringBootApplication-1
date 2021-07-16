package com.example.demo.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.Employee;

@Profile("test")
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	//List<Employee> findByEmpName(String name);
	//List<Employee> findByEmpSalBetween(float lower,float higher);
	
	@Query("from Employee where empName=:name")
	List<Employee> getUsingEmpName(@Param("name") String name);
	
	@Query("from Employee where empSal>=:lower and empSal<=:higher")
	List<Employee> getEmployeeBySal(@Param("lower") float lower,@Param("higher") float higher);

}
