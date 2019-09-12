<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Employee Details<br>
Employee ID  <%=session.getAttribute("eid") %><br>
Employee name <%=session.getAttribute("ename") %><br>
Employee basic salary <%=session.getAttribute("basicSalary") %><br>
Employee dob <%=session.getAttribute("edob") %><br>


</body>
</html>