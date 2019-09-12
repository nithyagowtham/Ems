package com.ems.model;

import java.time.LocalDate;

public class Employee {

		public String empid;
		String empName;
		float basicSalary;
		String password;
		LocalDate dob;

public Employee() {
	
}
public Employee(String empid,String empName,LocalDate dob,float basicSalary,String password)
{
	this.empid=empid;
	this.empName=empName;
	this.dob=dob;
	this.basicSalary= basicSalary;
	this.password=password;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmpid() {
	return empid;
}
public void setEmpid(String empid) {
	this.empid = empid;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public float getBasicSalary() {
	return basicSalary;
}
public void setBasicSalary(float basicSalary) {
	this.basicSalary = basicSalary;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
}