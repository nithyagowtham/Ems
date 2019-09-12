package com.ems.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceImpl;
import com.ems.service.employeeLoginService;

/**
 * Servlet implementation class EmployeeAdd
 */
@WebServlet({"/EmployeeAdd","/add"})
public class EmployeeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("eid");
		String epass=request.getParameter("epass");
		String ename=request.getParameter("ename");
		String dob=request.getParameter("dob");
//		String strDate=in.readLine();
//		StringTokenizer stk=new StringTokenizer(dob,"-");
//		int date=Integer.parseInt(stk.nextToken());
//		int month=Integer.parseInt(stk.nextToken());
//		int year=Integer.parseInt(stk.nextToken());
//		dob=LocalDate.of(year, month, date);
		LocalDate ld=LocalDate.parse(dob);
		float basicSalary=Float.parseFloat(request.getParameter("basicSalary"));
		Employee e=new Employee();
		e.setEmpid(eid);
		e.setEmpName(ename);
		e.setBasicSalary(basicSalary);
		e.setDob(ld);
		e.setPassword(epass);
		EmployeeServiceImpl ls=new EmployeeServiceImpl();
		try {
			if(ls.validateEmployee(e))
			{
				ls.save(e);
//				HttpSession ssn=request.getSession();
//				ssn.setAttribute("eid",eid);
//				response.sendRedirect("welcome.jsp");
			}
			else
				response.sendRedirect("login.jsp");
		} catch (Exception E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
	}
	}


