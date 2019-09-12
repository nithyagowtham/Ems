
<%@page import="com.ems.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<thead>
<tr>
<th>Emp Id</th>
<th>User Name</th>
<th>DoB</th>
<th>Salary</th>
</tr>
</thead>
<tbody>
<%
List<Employee> list = (List<Employee>) session.getAttribute("elist");
%>

<%
for (Employee emp : list) {
%>
<tr>
<td><%=emp.getEmpid()%></td>
<td><%=emp.getEmpName()%></td>
<td><%=emp.getDob()%></td>
<td><%=emp.getBasicSalary()%></td>
</tr>
<%
}
%>
</tbody>
</table>
<a href="main.jsp" >Home</a>
</body>
</html>