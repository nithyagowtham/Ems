package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class displayController
 */
@WebServlet({ "/displayController", "/display" })
public class displayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("disid");
		
		EmployeeServiceImpl ls=new EmployeeServiceImpl();
		Employee emp;
		
		try {
			emp = ls.getEmployee(eid);
			HttpSession ssn=request.getSession();
			ssn.setAttribute("eid",eid);
			ssn.setAttribute("ename",emp.getEmpName());
			ssn.setAttribute("edob",emp.getDob());
			ssn.setAttribute("basicSalary",emp.getBasicSalary());
			
			response.sendRedirect("show.jsp");
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
