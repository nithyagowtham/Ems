package com.ems.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class updateController
 */
@WebServlet({ "/updateController", "/update" })
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		String newname=request.getParameter("newname");
		String newdob=request.getParameter("newdob");
		float newbasic=Float.parseFloat(request.getParameter("newbasic"));
		String newpassword=request.getParameter("newpassword");
		
		LocalDate ld=LocalDate.parse(newdob);
		Employee e=new Employee();
		e.setEmpid(uid);
		e.setEmpName(newname);
		e.setBasicSalary(newbasic);
		e.setDob(ld);
		e.setPassword(newpassword);
		EmployeeServiceImpl ls=new EmployeeServiceImpl();
		
		try {
			if(ls.update(e)) {
				response.getWriter().println("updated successfully");
			}
			else {
				response.getWriter().println("updation failed");
			}
		
			
			
		} catch (Exception E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
	}

}
