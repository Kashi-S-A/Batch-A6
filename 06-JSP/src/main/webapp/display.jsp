<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		String name=request.getParameter("un");
	    String email=request.getParameter("ue");
	    String phone=request.getParameter("up");
	
	%>
	
	<h1>User Data</h1>
	<h2>Name : <%=name %></h2>
	<h2>Email : <%=email %></h2>
	<h2>Phone : <%=phone %></h2>
	
	<hr>
	
	<h1>Again,</h1>
	<h2>Name : <%=request.getParameter("un") %></h2>
	<h2>Email : <%=request.getParameter("ue") %></h2>
	<h2>Phone : <%=request.getParameter("up") %></h2>
 
</body>
</html>