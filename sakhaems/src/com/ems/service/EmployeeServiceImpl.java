package com.ems.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.ems.dao.EmployeeDao;
import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;
import com.ems.util.InvalidDobException;
import com.ems.util.InvalidNameException;
import com.ems.util.InvalidSalaryException;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao;
	public EmployeeServiceImpl() {
		dao=new EmployeeDaoImpl();
	}


	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		String empName=emp.getEmpName();
		LocalDate dob=emp.getDob();
		float salary=emp.getBasicSalary();
		
		if(empName.length()<4|| empName.length()>15){
			throw new InvalidNameException("Name must be in 4-15 characters");
			
		}
		if(dob.isAfter(LocalDate.of(1995, 12, 31))||dob.isBefore(LocalDate.of(1990, 1, 1))) {
			throw new InvalidDobException("must be between 1995 to 1990");
			
		}
		if(salary>80000|| salary<20000)
			throw new InvalidSalaryException("salary should be between 80k to 20k");
		return true;
		
	}

	@Override
	public String generateId(String empName) throws Exception {
		String nameChar=empName.substring(0,2).toUpperCase();
		Random rand=new Random();
		int dgt =(int)(rand.nextDouble()*10000);
		return nameChar+dgt;
	}

	

	@Override
	public boolean save(Employee emp) throws Exception {
		if(validateEmployee(emp)) {
			emp.setEmpid(generateId(emp.getEmpName()));
			return dao.save(emp);
		}
		return false;
			
	}
		

	@Override
	public boolean delete(String empid) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(empid);
	
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		if(validateEmployee(emp)) {
			return dao.update(emp);
		}
		return false;
	}

	@Override
	public Employee getEmployee(String empid) throws Exception {
		// TODO Auto-generated method stub
		return dao.getEmployee(empid);
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllEmployee();
	}
	

	
}
