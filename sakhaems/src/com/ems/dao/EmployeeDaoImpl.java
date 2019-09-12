package com.ems.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;



public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	@Override
	public Connection getConnection() throws Exception{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ems","skaha-dell-1","welcome");
		return con;
	
	}
	

	
	
	
	@Override
	public boolean save(Employee emp) throws Exception{
		// TODO Auto-generated method stub
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee1 values(?,?,?,?,?)");
		ps.setString(1,emp.getEmpid())	;
		ps.setString(2,emp.getEmpName());
		LocalDate dobRaw= emp.getDob();
		//String strDate =dobRaw.getYear()+"-"+dobRaw.getMonthValue()+"-"+dobRaw.getDayOfMonth();
		ps.setDate(3, new java.sql.Date(dobRaw.getYear()-1900,dobRaw.getMonthValue()-1,dobRaw.getDayOfMonth()));
		ps.setFloat(4,emp.getBasicSalary());
		ps.setString(5, emp.getPassword());
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	}

	@Override
	public boolean delete(String empid) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		con=getConnection();
//		System.out.println("enter emp id to delete");
//		String empId =sc.readLine();
		PreparedStatement ps=con.prepareStatement("delete from employee1 where empId=?");
		ps.setString(1,empid);
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	}

	@Override
	public boolean update(Employee emp) throws Exception  {
		// TODO Auto-generated method stub
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("Update employee1 set empname=?,dob=?,basicsalary=?,password=? where empid=? ");
		ps.setString(1,emp.getEmpName());
		
		LocalDate dobRaw= emp.getDob();
		ps.setDate(2, new java.sql.Date(dobRaw.getYear(),dobRaw.getMonthValue(),dobRaw.getDayOfMonth()));
		ps.setFloat(3,emp.getBasicSalary());
		ps.setString(4, emp.getPassword());
		ps.setString(5, emp.getEmpid());
		int r=ps.executeUpdate();
		return r>0?true:false;
		
	
	}

	@Override
	public Employee getEmployee(String empid) throws Exception {
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee1 where empid=? ");
		ps.setString(1,empid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			java.sql.Date rowDate=rs.getDate(3);
			Employee emp=new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowDate.getYear(), rowDate.getMonth(),rowDate.getDate()),rs.getFloat(4),rs.getString(5));
			return emp;
		}
		return null;
		
	}

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee1");
		List<Employee> empList= new ArrayList<>();
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			java.sql.Date rowDate=rs.getDate(3);
			Employee emp=new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowDate.getYear(), rowDate.getMonth(),rowDate.getDate()),rs.getFloat(4),rs.getString(5));
			empList.add(emp);
		}
		return empList;
		
	}
		
	}





	

