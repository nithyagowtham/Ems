package com.ems.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class deleteController
 */
@WebServlet({ "/deleteController", "/delete" })
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eid=request.getParameter("did");
		
		EmployeeServiceImpl ls=new EmployeeServiceImpl();
		try {
			if(ls.delete(eid))
			{
				response.getWriter().println("deleted successfully");
//				HttpSession ssn=request.getSession();
//				ssn.setAttribute("eid",eid);
//				response.sendRedirect("welcome.jsp");
			}
			else
				response.getWriter().println("failed");
		} catch (Exception E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
	}
	}
