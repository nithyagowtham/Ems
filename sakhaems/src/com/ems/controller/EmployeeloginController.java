package com.ems.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ems.service.employeeLoginService;

/**
 * Servlet implementation class EmployeeloginController
 */
@WebServlet({ "/EmployeeloginController", "/employeelogin" })
public class EmployeeloginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeloginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("eid");
		String epass=request.getParameter("epass");
		employeeLoginService ls=new employeeLoginService();
		try {
			if(ls.isValidate(eid,epass))
			{
				HttpSession ssn=request.getSession();
				ssn.setAttribute("eid",eid);
				response.sendRedirect("welcome.jsp");
			}
			else
				response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
