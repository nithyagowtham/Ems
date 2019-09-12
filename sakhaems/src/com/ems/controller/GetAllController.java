package com.ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.model.Employee;
import com.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class GetAllController
 */
@WebServlet({ "/GetAllController", "/getall" })
public class GetAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeServiceImpl emi = new EmployeeServiceImpl();
		List<Employee> employeeList = new ArrayList();
		try {
		employeeList = emi.getAllEmployee();
		HttpSession ssn = request.getSession();
		ssn.setAttribute("elist", employeeList);
		response.sendRedirect("Getall.jsp");

		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}

		
	}


