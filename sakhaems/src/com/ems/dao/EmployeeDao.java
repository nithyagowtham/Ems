package com.ems.dao;

import java.sql.Connection;
import java.util.List;

import com.ems.model.Employee;

public interface EmployeeDao {
	public Connection getConnection() throws Exception;
	public boolean save(Employee emp) throws Exception;
	public boolean delete(String empid) throws Exception;
	public boolean update(Employee emp) throws Exception;
	public Employee getEmployee(String empid)throws Exception;
	public List<Employee> getAllEmployee() throws Exception;
	
	
	


}
